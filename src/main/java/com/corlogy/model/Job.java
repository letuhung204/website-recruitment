package com.corlogy.model;

import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author hung
 */
@Entity
@Table(name = "job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "image")
    private String image;
    @Nationalized
    @Column(name = "title")
    private String title;
    @Nationalized
    @Column(name = "job_description", length = 1000)
    private String jobDescription;
    @Nationalized
    @Column(name = "requirement", length = 1000)
    private String requirement;
    @Nationalized
    @Column(name = "buffer", length = 1000)
    private String buffer;
    @Nationalized
    @Column(name = "publisher", length = 1000)
    private String publisher;
    @Nationalized
    @Column(name = "type_job", length = 1000)
    private String typeJob;

    @Nationalized
    @Column(name = "title_en")
    private String titleEn;
    @Nationalized
    @Column(name = "job_description_en", length = 1000)
    private String jobDescriptionEn;
    @Nationalized
    @Column(name = "requirement_en", length = 1000)
    private String requirementEn;
    @Nationalized
    @Column(name = "buffer_en", length = 1000)
    private String bufferEn;


    public Job() {
    }

    public Job(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getJobDescriptionEn() {
        return jobDescriptionEn;
    }

    public void setJobDescriptionEn(String jobDescriptionEn) {
        this.jobDescriptionEn = jobDescriptionEn;
    }

    public String getRequirementEn() {
        return requirementEn;
    }

    public void setRequirementEn(String requirementEn) {
        this.requirementEn = requirementEn;
    }

    public String getBufferEn() {
        return bufferEn;
    }

    public void setBufferEn(String bufferEn) {
        this.bufferEn = bufferEn;
    }

    public String getTypeJob() {
        return typeJob;
    }

    public void setTypeJob(String typeJob) {
        this.typeJob = typeJob;
    }
}
