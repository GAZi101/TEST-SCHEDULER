package com.example.testjava.testjava.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSiswa is a Querydsl query type for Siswa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSiswa extends EntityPathBase<Siswa> {

    private static final long serialVersionUID = 1912933329L;

    public static final QSiswa siswa = new QSiswa("siswa");

    public final StringPath id = createString("id");

    public final StringPath kelas = createString("kelas");

    public final StringPath nama = createString("nama");

    public final ListPath<nilai, Qnilai> nilai = this.<nilai, Qnilai>createList("nilai", nilai.class, Qnilai.class, PathInits.DIRECT2);

    public QSiswa(String variable) {
        super(Siswa.class, forVariable(variable));
    }

    public QSiswa(Path<? extends Siswa> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSiswa(PathMetadata metadata) {
        super(Siswa.class, metadata);
    }

}

