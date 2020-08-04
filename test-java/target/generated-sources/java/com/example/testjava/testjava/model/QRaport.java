package com.example.testjava.testjava.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRaport is a Querydsl query type for Raport
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRaport extends EntityPathBase<Raport> {

    private static final long serialVersionUID = -864722682L;

    public static final QRaport raport = new QRaport("raport");

    public final StringPath id = createString("id");

    public final StringPath mataPelajaran = createString("mataPelajaran");

    public final StringPath nama = createString("nama");

    public final NumberPath<Integer> nilai = createNumber("nilai", Integer.class);

    public final ListPath<nilai, Qnilai> nilaiList = this.<nilai, Qnilai>createList("nilaiList", nilai.class, Qnilai.class, PathInits.DIRECT2);

    public QRaport(String variable) {
        super(Raport.class, forVariable(variable));
    }

    public QRaport(Path<? extends Raport> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRaport(PathMetadata metadata) {
        super(Raport.class, metadata);
    }

}

