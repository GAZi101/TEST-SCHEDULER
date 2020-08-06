package com.example.testjava.testjava.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * Qnilai is a Querydsl query type for nilai
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qnilai extends EntityPathBase<nilai> {

    private static final long serialVersionUID = 1937860995L;

    public static final Qnilai nilai1 = new Qnilai("nilai1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath id_pelajar = createString("id_pelajar");

    public final StringPath mataPelajaran = createString("mataPelajaran");

    public final NumberPath<Integer> nilai = createNumber("nilai", Integer.class);

    public Qnilai(String variable) {
        super(nilai.class, forVariable(variable));
    }

    public Qnilai(Path<? extends nilai> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qnilai(PathMetadata metadata) {
        super(nilai.class, metadata);
    }

}

