package ru.gbuac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "doctype")
public class DocType extends NamedEntity {
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "docType")
    //private List<Doc> docs;
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "docType")
    //private List<DocTypeFields> docTypeFields;

    @Column(name = "appendix_template_filename")
    private String appendixTemplateFileName;

    @Column(name = "template_filename")
    private String templateFileName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docType")
    private List<Doc> doc;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_number_prefix_id", nullable = false)
    private DocNumberPrefixes docNumberPrefixes;

    @Column(name = "final_doc")
    private boolean finalDoc;

    @JsonIgnore
    @Column(name = "publish_name_mask")
    private String publishNameMask;

    @JsonIgnore
    @Column(name = "publish_classifier_params")
    private String publishClassifierParams;
}
