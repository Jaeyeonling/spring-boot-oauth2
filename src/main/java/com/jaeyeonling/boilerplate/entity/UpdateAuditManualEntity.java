package com.jaeyeonling.boilerplate.entity;

import com.jaeyeonling.boilerplate.entity.converter.LocalDateTimeConverter;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class UpdateAuditManualEntity extends ManualPrimaryEntity {

    @Getter
    @Column(nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    //
    //
    //

    UpdateAuditManualEntity(final long id) {
        super(id);
    }
}
