# TEST-SCHEDULER


Aplikasi ini memproses file csv untuk disimpan
kedalam database sesuai jam selesai kerja
jam dibuat cron disetting di 'application.properties',
didalam folder input (path dimasukan tbl_parameter)

Untuk melihat data yg sudah berhasil disimpan

"Context_path":8080/getListRaport
Param :
page*
pageSize*
nomor_induk
mata_pelajaran
nama
nilai

Untuk update nilai 

"Context_path":8080/update-nilai
Param :
nomor_induk
nilai

Untuk delete mata pelajaran

"Context_path":8080/delete-matapelajaran
Param :
nomor_induk

