package moi.projet.carrental.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import java.time.LocalDate;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditTable implements Serializable {

    @CreatedDate
    @Column(updatable = false)
    private LocalDate createDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDate updateDate;

    @CreatedBy
    @Column(updatable = false , nullable = true)
    private String createdBy;

    @LastModifiedBy
    @Column(nullable = true)
    private String updatedBy;



}
