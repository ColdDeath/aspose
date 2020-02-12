package ru.gbuac.service;

import ru.gbuac.model.ResolutionsUsers;
import ru.gbuac.util.exception.NotFoundException;

public interface ResolutionsUsersService {
    ResolutionsUsers save(int userId, int docId);

    void delete(int userId, int docId) throws NotFoundException;
}
