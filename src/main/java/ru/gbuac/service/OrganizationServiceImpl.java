package ru.gbuac.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.OrganizationRepository;
import ru.gbuac.model.Organization;
import ru.gbuac.to.OrganizationTo;
import ru.gbuac.util.exception.NotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static ru.gbuac.util.ValidationUtil.checkNotFound;
import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization get(int id) throws NotFoundException {
        return checkNotFoundWithId(organizationRepository.findById(id).orElse(null), id);
    }

    @Override
    public Organization getByInn(String inn) throws NotFoundException {
        return checkNotFound(organizationRepository.getByInn(inn), "inn="+inn);
    }

    @Override
    public List<OrganizationTo> getAll() {
        return organizationRepository.getAll();
    }

    @Override
    public Organization getEGRULData(String INN) {
        JSONObject query = new JSONObject();
        query.put("query", INN);
        query.put("branch_type", "MAIN");
        String JSONString = query.toJSONString();

        Organization returned = new Organization();
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
        String uri = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/party";
        if (INN.matches("[0-9]+") && INN.length() > 2) {
            uri = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party";
        }
        try {
            HttpPost request = new HttpPost(uri);
            StringEntity params = new StringEntity(JSONString, "UTF-8");
            params.setContentEncoding("UTF-8");
            params.setContentType("application/json");
            request.addHeader("Authorization", "Token 13c49f7cdb1ab14887f0329ff2bba40073a74c25");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            String data = EntityUtils.toString(response.getEntity());
            JsonParser parser = new JsonParser();
            JsonObject root = parser.parse(data).getAsJsonObject();


            JsonObject jsonObjectSuggestions = root.get("suggestions").getAsJsonArray().get(0).getAsJsonObject();

            JsonObject jsonObjectData = jsonObjectSuggestions.get("data").getAsJsonObject();
            returned.setKpp(jsonObjectData.get("kpp").getAsString());
            returned.setOgrn(jsonObjectData.get("ogrn").getAsString());
            returned.setInn(jsonObjectData.get("inn").getAsString());
            returned.setShortNameLf(jsonObjectData.get("name").getAsJsonObject().get("short_with_opf").getAsString());
            returned.setFullNameLf(jsonObjectData.get("name").getAsJsonObject().get("full_with_opf").getAsString());
            returned.setAddress(jsonObjectData.get("address").getAsJsonObject().get("value").getAsString());
            returned.setFioManager(jsonObjectData.get("management").getAsJsonObject().get("name").getAsString());
            returned.setPositionManager(jsonObjectData.get("management").getAsJsonObject().get("post").getAsString());
        }   catch (Exception ex) {

        }
        return returned;
    };

    private String replaceQuotes(String text) {
        long quotesCount = text.chars().filter(ch -> ch == '"').count();
        if (quotesCount != 0) {
            text = replaceQuotes(replaceLast(text.replaceFirst("\"","«"), "\"", "»"));
        }
        return text;
    }

    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    public String convert(InputStream inputStream, Charset charset) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    @Override
    public Organization save(Organization organization) {
        Assert.notNull(organization, "organization must not be null");
        Organization existedOrganization = organizationRepository.getByInn(organization.getInn());
        if (existedOrganization != null) {
            organization.setId(existedOrganization.getId());
        }

        return organizationRepository.save(organization);
    }

    @Override
    public Organization update(Organization organization, int id) throws NotFoundException {
        Assert.notNull(organization, "organization must not be null");
        return checkNotFoundWithId(organizationRepository.save(organization), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        organizationRepository.delete(id);
    }
}
