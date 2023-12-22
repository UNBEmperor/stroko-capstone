package com.stroke.stroke_ch2_ps208.utils

import com.stroke.stroke_ch2_ps208.domain.enity.ListArticle
import com.stroke.stroke_ch2_ps208.domain.enity.Notification
import com.stroke.stroke_ch2_ps208.domain.enity.Promo


object DummyData {
    fun provideImage() = listOf(
        "https://s5.gifyu.com/images/SjbLv.png",
    )

    fun providePromos() = listOf(
        Promo(
            name = "Pelajari Tentang Pencegahan Stroke!",
            imageUrl = "https://s5.gifyu.com/images/SiAtk.png",
            bgColor = "#0088E0"
        ),
        Promo(
            name = "Kenali Tanda Peringatan Stroke",
            imageUrl = "https://s5.gifyu.com/images/SiA5i.png",
            bgColor = "#4F0DF0"
        ),
        Promo(
            name = "Gratis Penilaian Risiko Stroke Hari Ini!",
            imageUrl = "https://s5.gifyu.com/images/SiAtf.png",
            bgColor = "#0088E0"
        ),
        Promo(
            name = "Kebiasaan Sehat untuk Mengurangi Risiko Stroke",
            imageUrl = "https://s5.gifyu.com/images/SiA5g.png",
            bgColor = "#4F0DF0"
        ),
        Promo(
            name = "Workshop Kesadaran Stroke - Bergabung Sekarang!",
            imageUrl = "https://s5.gifyu.com/images/SiA5I.png",
            bgColor = "#0088E0"
        )
    )

    fun provideNotifications() = listOf(
        Notification(
            name = "Tips Makan Sehat",
            type = 1,
            description = "Temukan rekomendasi makanan yang dipersonalisasi untuk mengurangi risiko stroke. Jelajahi berbagai pilihan nutrisi yang disesuaikan dengan preferensi diet Anda."
        ),
        Notification(
            name = "Saran Resep Baru",
            type = 0,
            description = "Jelajahi resep lezat dan sehat untuk mendukung kesehatan jantung. Tingkatkan diet Anda dengan hidangan beraroma yang berkontribusi pada pencegahan stroke."
        ),
        Notification(
            name = "Wawasan Nutrisi",
            type = 2,
            description = "Tetap terinformasi tentang wawasan nutrisi terbaru. Pelajari bagaimana menyertakan makanan tertentu dalam diet Anda dapat berdampak positif pada kesehatan kardiovaskular dan mengurangi risiko stroke."
        )
    )


    fun provideStrokeArticles(): List<ListArticle> {
        return listOf(
            ListArticle(
                1,
                name = "Apa itu Stroke ?",
                publish = "P2PTM Kemenkes RI",
                imageUrl = "https://p2ptm.kemkes.go.id/uploads/TmQwU05BQS9YYlJpanB5VnNtRldFUT09/4_Juli_2018_07.png",
                publishDate = "04 Juli 2018",
                description = "Stroke adalah penyakit pembuluh darah otak. Definisi menurut WHO, Stroke adalah suatu keadaan dimana ditemukan tanda-tanda klinis yang berkembang cepat berupa defisit neurologik fokal dan global, yang dapat memberat dan berlangsung lama selama 24 jam atau lebih dan atau dapat menyebabkan kematian, tanpa adanya penyebab lain yang jelas selain vascular.\n" +
                        "Stroke terjadi apabila pembuluh darah otak mengalami penyumbatan atau pecah. Akibatnya sebagian otak tidak mendapatkan  pasokan darah yang membawa oksigen yang diperlukan sehingga mengalami kematian sel/jaringan.\n"
            ),
            ListArticle(
                2,
                name = "Faktor Risiko Stroke yang Dapat Diubah",
                publish = "P2PTM Kemenkes RI",
                imageUrl = "https://p2ptm.kemkes.go.id/uploads//TmQwU05BQS9YYlJpanB5VnNtRldFUT09/19_Juli_05.png",
                publishDate = "19 Juli 2019",
                description = "Faktor Risiko Stroke yang Bisa diubah\n" +
                        "Hipertensi, Diabetes Melitus, Merokok, Atrial Fibrilasi, Penyakit Jantung lainnya, Pasca Stroke, Dislipidemia, Konsumsi alkohol, Penyalahgunaan obat, Stenosis arteri karotis, Hiperfibrinogenemia, Hiperhomosisteinemia, Obesitas, Pemakaian kontrasepsi hormonal, Stres mental fisik, Migrain, Kurang aktivitas fisik, Sickle cell anemia\n"
            ),
            ListArticle(
                3,
                name = "Faktor Risiko Stroke yang Tidak Bisa Diubah",
                publish = "P2PTM Kemenkes RI",
                imageUrl = "https://p2ptm.kemkes.go.id/uploads//TmQwU05BQS9YYlJpanB5VnNtRldFUT09/19_Juli_04.png",
                publishDate = "19 Juli 2019",
                description = "Faktor-faktor yang merupakan penyebab stroke, secara statistik berkaitan erat dengan kelompok ras tertentu, umur tertentu dan jenis kelamin\n" +
                        "\n" +
                        "Umur: Berumur diatas 55 tahun\n" +
                        "Jenis Kelamin: Berjenis kelamin pria\n" +
                        "Ras Tertentu\n" +
                        "Genetik: Riwayat keluarga stroke (ayah, ibu, saudara sekandung, anak)\n" +
                        "\n" +
                        "Apabila individu ditemukan dalam keadaan tersebut bukan berarti tindakan pencegahan stroke tidak dapat dilakukan, melainkan melalui tindakan yang berkaitan dengan pencegahan stroke secara menyeluruh.\n"
            ),
            ListArticle(
                10,
                name = "Bahaya Stroke",
                publish = "P2PTM Kemenkes RI",
                imageUrl = "https://p2ptm.kemkes.go.id/uploads//TmQwU05BQS9YYlJpanB5VnNtRldFUT09/2_November_06.png",
                publishDate = "02 November 2018",
                description = "Faktor Risiko Stroke yang Bisa diubah\n" +
                        "Hipertensi, Diabetes Melitus, Merokok, Atrial Fibrilasi, Penyakit Jantung lainnya, Pasca Stroke, Dislipidemia, Konsumsi alkohol, Penyalahgunaan obat, Stenosis arteri karotis, Hiperfibrinogenemia, Hiperhomosisteinemia, Obesitas, Pemakaian kontrasepsi hormonal, Stres mental fisik, Migrain, Kurang aktivitas fisik, Sickle cell anemia\n"
            ),
            ListArticle(
                4,
                name = "Jenis-Jenis Stroke",
                publish = "P2PTM Kemenkes RI",
                imageUrl = "https://p2ptm.kemkes.go.id/uploads//TmQwU05BQS9YYlJpanB5VnNtRldFUT09/4_Juli_2018_08_2.png",
                publishDate = "04 Juli 2018",
                description = "Stroke Iskemik (Stroke Sumbatan), Stroke yang paling sering terjadi\n" +
                        "\n" +
                        "Stroke Emboli : Bekuan darah atau plak yang terbentuk di dalam jantung atau pembuluh arteri besar yang terangkut menuju otak \n" +
                        "\n" +
                        "Stroke Trombotik : Bekuan darah atau plak yang terbentuk di dalam pembuluh arteri yang mensuplai darah ke otak\n" +
                        "\n" +
                        "Stroke Hemoragik (Stroke Berdarah)\n" +
                        "\n" +
                        "Perdarahan Intraserebral : Pecahnya pembuluh darah dan darah masuk ke dalam jaringan yang menyebabkan sel-sel otak mati sehingga berdampak pada kerja otak berhenti. Penyebab tersering adalah Hipertensi\n" +
                        "Perdarahan Subarachnoid : Pecahnya pembuluh darah yang berdekatan dengan permukaan otak dan darah bocor di antara otak dan tulang tengkorak. Penyebabnya bisa berbeda-beda, tetapi biasanya karena pecahnya aneurisma\n"
            ),
            ListArticle(
                5,
                name = "Gejala dan tanda-tanda Stroke",
                publish = "P2PTM Kemenkes RI",
                imageUrl = "https://p2ptm.kemkes.go.id/uploads//TmQwU05BQS9YYlJpanB5VnNtRldFUT09/18_Desember_2020_03.png",
                publishDate = "18 Desember 2020",
                description = "Senyum tidak simetris (mencong ke satu sisi), tersedak, sulit menelan air minum secara tiba-tiba\n" +
                        "Gerak separuh anggota tubuh melemah tiba-tiba\n" +
                        "bicaRa pelo / tiba-tiba tidak dapat bicara / tidak mengerti kata-kata / bicara tidak nyambung\n" +
                        "Kebas atau baal, atau kesemutan separuh tubuh\n" +
                        "Rabun, pandangan satu mata kabur, terjadi tiba-tiba\n" +
                        "Sakit kepala hebat yang muncul tiba-tiba dan tidak pernah dirasakan sebelumnya, Gangguan fungsi keseimbangan, seperti terasa berputar, gerakan sulit dikoordinasi (tremor / gemetar, sempoyongan).\n"
            ),
            ListArticle(
                6,
                name = "Bagaimana Perawatan Pasien Stroke Iskemik di Rumah?",
                publish = "Siti Amanah, Ners - RSUP dr. Soeradji Tirtonegoro Klaten",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1690863493_241746.jpg",
                publishDate = "01 Agustus 2023",
                description = "Stroke Iskemik diakibatkan oleh Aterotrombosis (radang Aterosklerosis yang disertai dengan pembentukan Trombus yang kaya akan keping darah) pembuluh darah serebral baik yang besar maupun kecil. Pada Stroke Iskemik, penyumbatan bisa terjadi disepanjang jalur pembuluh darah Arteri yang menuju ke otak. Darah ke otak disuplai oleh 2 (dua) Arteri Karotis Interna dan 2 (dua) Arteri Veterbralis. Arteri-arteri ini merupakan cabang dari lengkung Aorta Jantung. Suatu Ateroma (endapan lemak) bisa terbentuk di dalam pembuluh darah Arteri Karotis sehingga menyebabkan berkurangnya aliran darah. Tingkat keparahan atau gejala yang timbul tergantung dari besarnya area otak yang terganggu akibat tersumbatnya pembuluh darah di otak.\n" +
                        "\n" +
                        "\n" +
                        "Kemungkinan masalah kesehatan yang dialami pasien pasca stroke di rumah :\n" +
                        "\n" +
                        "1.      Kelumpuhan / kelemahan separo badan atau Hemiparese.\n" +
                        "\n" +
                        "2.      Gangguan keseimbangan duduk atau berdiri.\n" +
                        "\n" +
                        "3.      Gangguan berbicara dan gangguan berkomunikasi.\n" +
                        "\n" +
                        "4.      Gangguan menelan\n" +
                        "\n" +
                        "5.      Gangguan buang air kecil atau inkontinensia.\n" +
                        "\n" +
                        "6.      Gangguan buang air besar atau konstipasi.\n" +
                        "\n" +
                        "7.      Kesulitan mengenakan pakaian.\n" +
                        "\n" +
                        "8.      Gangguan memori atau daya ingat.\n" +
                        "\n" +
                        "9.      Perubahan kepribadian dan emosi.\n" +
                        "\n" +
                        "10.   Kesulitan ADL (Activity of Daily Living) / aktifitas sehari-hari.\n" +
                        "\n" +
                        "Tindakan yang dapat dilakukan setelah diperbolehkan pulang dari rumah sakit :\n" +
                        "\n" +
                        "1.      Teratur konsumsi obat\n" +
                        "\n" +
                        "Pastikan minum obat dengan rutin dan teratur sesuai resep dokter dan memperhatikan prinsip 4 benar / 4 B (benar obat, benar waktu, benar cara, benar dosis). Tidak disarankan mengkonsumsi obat atau suplemen tanpa rekomendasi dokter.\n" +
                        "\n" +
                        "2.      Pola makan sehat\n" +
                        "\n" +
                        "a.      Makanan yang dianjurkan.\n" +
                        "\n" +
                        "1)     Bahan makanan yang mengandung lemak tak jenuh : minyak tumbuh-tumbuhan (minyak kacang tanah, minyak sawit, minyak jagung,  minyak kedelai, margarin).\n" +
                        "\n" +
                        "2)     Sumber karbohidrat\n" +
                        "3)     Sumber protein\n" +
                        "\n" +
                        "4)     Sayuran dan buah-buahan yang tidak menimbulkan gas.\n" +
                        "\n" +
                        "5)     Makanan rendah garam.\n" +
                        "\n" +
                        "b.      Makanan yang dihindari.\n" +
                        "\n" +
                        "1)     Lemak jenuh\n" +
                        "\n" +
                        "2)     Jeroan dan olahan daging.\n" +
                        "\n" +
                        "3)     Minuman soda dan alkohol.\n" +
                        "\n" +
                        "4)     Makanan yang diawetkan.\n" +
                        "\n" +
                        "3.      Berhenti merokok dan berhenti minum minuman beralkohol\n" +
                        "\n" +
                        "Pasien yang masih tetap merokok setelah terkena Stroke 2 kali lebih berisiko mengalami Stroke berulang disbanding pasien yang tidak merokok. Pasien Pasca Stroke yang mengonsumsi alcohol memiliki kemungkinan terkena Stroke berulang dalam 90 hari.\n" +
                        "\n" +
                        "Tips berhenti\n" +
                        "\n" +
                        "a.      Patuhi peraturan pemerintah tentang kawasan tanpa rokok.\n" +
                        "\n" +
                        "b.      Niat dari dalam diri untuk berhenti merokok.\n" +
                        "\n" +
                        "c.      Mulai mengurangi jumlah batang rokok per hari.\n" +
                        "\n" +
                        "d.      Jauhi hal-hal yang berhubungan / mengingatkan dengan rokok  seperti korek api, bungkus rokok dan asbak.\n" +
                        "\n" +
                        "e.      Minta dukungan dari keluarga dan sahabat.\n" +
                        "\n" +
                        "4.      Rutin melakukan aktifitas fisik dan istirahat.\n" +
                        "\n" +
                        "a.      Aktivitas fisik pasien tanpa kelemahan otot.\n" +
                        "\n" +
                        "1)     Anjuran aktivitas fisik\n" +
                        "\n" +
                        "a)     Pasien terbiasa tirah baring selama di Unit Stroke,  sehingga bisa muncul  gangguan keseimbangan.\n" +
                        "\n" +
                        "b)     Minggu pertama dianjurkan jalan santai.\n" +
                        "\n" +
                        "c)     Minggu selanjutnya pasien dapat senam, berenang maupun bersepeda.\n" +
                        "\n" +
                        "d)     Kegiatan dapat dilakukan 3x / minggu atau sesuai kemampuan pasien.\n" +
                        "2)     Istirahat cukup\n" +
                        "\n" +
                        "a)     Pastikan pasien cukup istirahat di rumah (tidur 6-8 jam).\n" +
                        "\n" +
                        "b)     Hindari stres\n" +
                        "\n" +
                        "c)     Hentikan aktivitas fisik / olahraga bila merasa lelah.\n" +
                        "\n" +
                        "d)     Melakukan kegiatan sesuai kemampuan.\n" +
                        "\n" +
                        "b.      Aktivitas fisik pasien dengan kelemahan otot\n" +
                        "\n" +
                        "1)     Untuk mencegah kekakuan otot, maka pasien harus menggerakkan tubuh. \n" +
                        "\n" +
                        "2)     Pasien dibantu oleh keluarga untuk menggerakkan tangan atau kaki yang lemah.\n" +
                        "\n" +
                        "3)     Pada tangan dan kaki yang mampu bergerak, pasien  melakukan gerakan secara aktif.\n" +
                        "\n" +
                        "4)     Idealnya dilakukan 2-5 kali per hari.\n" +
                        "\n" +
                        "5)     Untuk mencegah timbulnya luka pada punggung, maka pasien perlu ganti posisi tiap 2-3 jam (miring kanan-terlentang-miring kiri).\n" +
                        "\n" +
                        "6)     Dapat diberikan bantal pada area yang menonjol (lutut, siku, kepala).\n" +
                        "\n" +
                        "7)     Bila memungkinkan, kasur pasien dapat dipasang Dekubitor bed.\n" +
                        "\n" +
                        "8)     Latihan aktifitas sehari-hari dengan tujuan mandiri.\n" +
                        "\n" +
                        "9)     Disiapkan alat bantu.\n" +
                        "\n" +
                        "5.      Sesuaikan kondisi rumah.\n" +
                        "\n" +
                        "a.      Penerangan baik\n" +
                        "\n" +
                        "b.      Lantai tidak licin.\n" +
                        "\n" +
                        "c.      Pakaian yang nyaman.\n" +
                        "\n" +
                        "d.      Menggunakan sandal di kamar mandi.\n" +
                        "\n" +
                        "e.      Dampingi pasien di kamar mandi.\n" +
                        "\n" +
                        "f.       Tempat tidur 15-30 cm dari lantai.\n" +
                        "\n" +
                        "g.      Pengaman tempat tidur.\n" +
                        "h.      Hindari perokok (mencegah perokok pasif).\n" +
                        "\n" +
                        "i.       Ventilasi yang baik.\n" +
                        "\n" +
                        "6.      Rutin Kontrol\n" +
                        "\n" +
                        "Setelah pasien diizinkan pulang,pasien dianjurkan kontrol secara rutin. Kontrol dilakukan untuk memantau perkembangan kondisi pasien. Saat kontrol akan dilakukan :\n" +
                        "\n" +
                        "a.      Konsultasi dengan dokter.\n" +
                        "\n" +
                        "b.      Pemeriksaan penunjang\n" +
                        "\n" +
                        "c.      Upaya rehabilitasi medik.\n" +
                        "\n" +
                        "d.      Peresepan obat rutin oleh dokter.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Referensi :\n" +
                        "\n" +
                        "The American Heart Association / American Stroke Association. 2021. Guideline for the Secondary Prevention of Ischemic Stroke.\n" +
                        "\n" +
                        "Tamam Badrid. 2020. Faktor Risiko terhadap Kejadian Stroke di RSUD Dr. Koesnadi Bondowoso. Skripsi Program Studi S-1 Keperawatan Fakultas Ilmu Kesehatan Universitas Muhammadiyah Jember.\n"
            ),
            ListArticle(
                7,
                name = "Gerakan Senam Kaki Diabetes",
                publish = "Ns. Mislawati Indah, S.Kep - RSUP Fatmawati Jakarta",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1702550570_478019.jpg",
                publishDate = "14 Desember 2023",
                description = "Senam kaki adalah Latihan menggerakkan lutut,kaki, telapak kaki dan jari–jari kaki yang ditujukan kepada penderita diabetes melitus. Pasien diabetes dapat melakukan gerakan senam kaki, sebagai berikut: \n" +
                        "\n" +
                        "Latihan senam kaki dapat dilakukan berdiri, duduk. Jika dilakukan dalam posisi duduk maka posisikan pasien duduk tegak di atas bangku dengan kaki menyentuh lantai,tidak bersandar dengan kursi, lantai harus rata dan bersih.\n" +
                        "Gerakkan telapak kaki keatas,tekuk jari–jari kaki seperti cakar ayam lakukan sebanyak10 kali.\n" +
                        "Angkat telapak kaki ke atas dengan posisi tumit di lantai, kemudian turunkan telapak kaki, naikkan tumit dengan posisi jari di lantai, lakukan Gerakan 10 kali.\n" +
                        "Angkat telapak kaki,dengan posisi tumit di lantai, lakukan Gerakan memutar sebanyak 10 kali.\n" +
                        "Tumit diangkat, dengan posisi jari –jari di lantai dan buat gerakan memutar dari dalam keluar dengan sebanyak 10 kali.\n" +
                        "Angkat salah satu kaki ke atas dengan meluruskan lutut. Buat putaran dengan pergerakan pada pergelangan kaki. Ulangi sebanyak 10 kali.\n" +
                        "Angkat salah satu kaki dan luruskan , gerakkan ujung jari kaki ke arah wajah sebanyak 10 kali.\n" +
                        "Angkat kedua kaki dan luruskan,pertahanka posisi tersebut, arahkan jari- jari kaki ke arah wajah sebanyak 10 kali.\n" +
                        "Angkat kedua kaki dan luruskan, pertahankan posisi tersebut. Gerakan pergelangan ke depan dan ke belakang. sebanyak 10 kali.\n" +
                        "Letakkan sehelai koran dilantai. Bentuk kertas itu menjadi seperti bola dengan kedua kaki. Kemudian, buka bola itu menjadi lembaran seperti semula menggunakan kedua kaki. Cara ini dilakukan sekali saja.\n" +
                        " \n" +
                        "\n" +
                        "Referensi :\n" +
                        "\n" +
                        "Camalia Suhertini & Subandi.(2016).Senam Kaki Efektif Mengobati Neuropati Diabetik Pada Penderita Diabetes Melitus.Jurnal Kesehatan,Volume VII Nomor 3.\n" +
                        "\n" +
                        "Flora,R,Hikayati & Purwanto,S.(2013).Pelatihan Senam Kaki Pada Penderita Diabetes Melitus Dalam Upaya Pencegahan Komplikasi Diabetes Pada Kaki (diabetes foot).Jurnal Pengabdian Sriwajaya,7-15.\n" +
                        "\n" +
                        "Kementrian Kesehatan RI Politeknik Kesehatan Kemenkes Semarang.(2021).Buku Panduan Senam Kaki Diabetik (Ankle Branchial Index) Pada Penderita Diabetes Melitus Tipe II.\n"
            ),
            ListArticle(
                8,
                name = "Manfaat Semangka untuk Kesehatan Jantung",
                publish = "dr. Fadhilla Umami - RS Jantung dan Pembuluh Darah Harapan Kita Jakarta",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1702004503_887081.jpg",
                publishDate = "08 Desember 2023",
                description = "Siapa yang tidak mengenal semangka? Semangka adalah buah yang mudah didapat. Selain rasanya yang enak dan segar semangka juga memiliki manfaat kesehatan yang luar biasa. Buah ini memiliki banyak keunggulan gizi dan manfaat kesehatan yang menjadikannya pilihan yang baik untuk dimasukkan dalam pola makan sehari-hari. Tahukah anda, salah satu manfaat penting dari semangka adalah perannya dalam kesehatan jantung. Dalam artikel ini, kami akan menjelaskan manfaat semangka untuk menjaga kesehatan jantung Anda.\n" +
                        "\n" +
                        "Kaya akan Lycopene:\n" +
                        "\n" +
                        "Semangka mengandung senyawa bernama likopen, yaitu pigmen alami yang memberikan warna merah pada buah ini. Likopen diketahui memiliki sifat antioksidan yang kuat dan dapat membantu melindungi jantung dari kerusakan akibat radikal bebas. Antioksidan ini juga dapat membantu mengurangi risiko penyakit kardiovaskular dengan mengurangi peradangan dan oksidasi di dalam tubuh.\n" +
                        "\n" +
                        "Mengandung Citrulline:\n" +
                        "\n" +
                        "Semangka juga merupakan sumber alami citrulline, sebuah asam amino non-esensial yang dapat meningkatkan produksi oksida nitrat dalam tubuh. Oksida nitrat membantu melebarkan pembuluh darah dan meningkatkan aliran darah ke jantung, sehingga membantu menjaga tekanan darah normal. Dengan demikian, konsumsi semangka secara teratur dapat membantu menjaga kesehatan kardiovaskular.\n" +
                        "\n" +
                        "Kandungan Kalium:\n" +
                        "\n" +
                        "Semangka mengandung jumlah kalium yang cukup tinggi. Kalium dibutuhkan oleh tubu kita. Kalium merupakan mineral penting yang berperan dalam menjaga keseimbangan elektrolit dalam tubuh dan mengatur tekanan darah. Mengonsumsi makanan yang kaya kalium, seperti semangka, dapat membantu menurunkan tekanan darah dan meminimalkan risiko penyakit jantung dan stroke.\n" +
                        "\n" +
                        "Kandungan Air:\n" +
                        "\n" +
                        "Kandungan air yang tinggi dalam semangka membantu menjaga hidrasi tubuh. Dehidrasi dapat menyebabkan peningkatan denyut jantung, sehingga meningkatkan beban kerja jantung. Dengan mengonsumsi semangka yang segar dan menghidrasi tubuh dengan baik, Anda dapat membantu menjaga detak jantung tetap stabil dan menjaga kesehatan jantung secara keseluruhan.\n" +
                        "\n" +
                        "Kesimpulan:\n" +
                        "\n" +
                        "Semangka bukan hanya buah yang segar dan lezat, tetapi juga memiliki manfaat yang baik bagi kesehatan jantung. Kandungan likopen, citrulline, kalium, dan kandungan air dalam semangka dapat membantu melindungi jantung dari kerusakan, menjaga tekanan darah normal, serta memelihara kesehatan jantung \n" +
                        "secara keseluruhan. Jumlah kalori yang dimiliki oleh semangka relatif rendah. Oleh karena itu, semangka dapat menjadi pilihan buah yang baik bagi mereka yang ingin menjaga berat badan atau mengonsumsi makanan rendah kalori. Namun, perlu diingat bahwa meskipun banyak manfaat yang dimiliki oleh semangka, seperti halnya buah lainnya, sebaiknya dikonsumsi dalam porsi yang wajar dan tidak berlebihan. Mengonsumsi semangka secara berlebihan bisa menyebabkan peningkatan asupan gula alami, yang perlu diperhatikan bagi orang dengan kondisi kesehatan tertentu seperti diabetes. Jangan lupa konsultasilah dengan dokter bila memiliki kondisi kesehatan tertentu."
            ),
            ListArticle(
                9,
                name = "Obat Hipertensi: Lebih Baik Diminum pada Pagi atau Malam Hari?",
                publish = "dr. Surya Buana Wangi - RS Jantung dan Pembuluh Darah Harapan Kita Jakarta",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1702004133_706700.jpg",
                publishDate = "18 Desember 2020",
                description = "Hipertensi merupakan salah satu masalah kesehatan masyarakat yang serius di seluruh dunia. Menurut World Health Organization (WHO), memperkirakan 31,1% populasi dewasa diseluruh dunia memiliki hipertensi, dengan prevalensi yang lebih tinggi pada negara berkembang , yakni sekitar 31,5% populasi dewasa.  Di Indonesia, data RISKESDAS tahun 2018 menunjukkan peningkatan prevalensi hipertensi dibandingkan tahun 2013, dari angka 25.8% menjadi 34,1% di tahun 2018. Peningkatan prevalensi ini memerlukan perhatian khusus, mengingat hipertensi merupakan faktor risiko utama penyakit renokardiovaskular, seperti stroke, penyakit jantung koroner, dan gagal ginjal. Hipertensi dapat disebabkan oleh suatu kondisi tertentu, gangguan ginjal misalnya, yang kita kita sebut sebagai hipertensi sekunder. Namun pada populasi lebih banyak ditemukan hipertensi esensial atau primer, dimana penyebab peningkatan tekanan darah tidak dapat diidentifikasi dengan jelas.  Dalam upaya pengendalian tekanan darah, terdapat banyak strategi yang dapat diterapkan, diantaranya seperti modifikasi gaya hidup, mengatur pola makan, tidak merokok, berolahraga teratur, dan tentunya dengan meminum obat hipertensi secara teratur." +
                        "Salah satu pertanyaan yang umum ditanyakan oleh pasien dengan hipertensi adalah mengenai kapan waktu yang optimal untuk meminum obat. Apakah lebih baik di pagi hari atau pada malam hari?" +
                        "Penelitian telah menunjukkan hasil yang bertentangan mengenai hal ini. Beberapa penelitian menunjukkan bahwa minum obat di pagi hari lebih efektif dalam mengontrol tekanan darah dibandingkan dengan minum obat di malam hari. Namun, penelitian lain menunjukkan bahwa minum obat di malam hari lebih efektif." +
                        "Waktu yang optimal untuk minum obat hipertensi tergantung pada berbagai faktor, seperti jenis obat, tingkat tekanan darah pasien, dan ritme sirkadian individu. Berikut ini adalah beberapa faktor yang perlu dipertimbangkan saat menentukan waktu terbaik untuk minum obat hipertensi:\n" +
                        "Jenis Obat" +
                        "Ada beberapa kelas obat yang berbeda yang digunakan dalam manajemen hipertensi, seperti diuretik, penghambat beta, penghambat enzim pengubah angiotensin (penghambat ACE), penghambat reseptor angiotensin II (ARB), dan penghambat saluran kalsium (CCB). Setiap obat memiliki mekanisme kerja dan waktu paruh yang unik, yang mempengaruhi waktu optimal untuk pemberian." +
                        "Sebagai contoh, diuretik biasanya diminum di pagi hari untuk mencegah nokturia (sering buang air kecil di malam hari). Penghambat ACE dan ARB memiliki waktu paruh yang lebih lama, dan penelitian telah menunjukkan bahwa mengonsumsi obat ini pada malam hari dapat menyebabkan penurunan tekanan darah yang lebih signifikan." +
                        "Tingkat Tekanan Darah\n" +
                        "Waktu minum obat juga dapat bergantung pada tingkat tekanan darah pasien. Untuk pasien yang tekanan darahnya terkontrol dengan baik, minum obat di pagi hari mungkin sudah cukup. Namun, untuk pasien dengan tekanan darah yang tidak terkontrol, minum obat di malam hari mungkin lebih efektif dalam menurunkan tekanan darah." +
                        "Ritme Sirkadian Individu" +
                        "Jam internal tubuh, atau ritme sirkadian, juga memengaruhi bagaimana obat dimetabolisme dan waktu optimal untuk pemberiannya. Ritme sirkadian mengontrol berbagai proses fisiologis, seperti suhu tubuh, sekresi hormon, dan tekanan darah." +
                        "Penelitian telah menunjukkan bahwa tekanan darah cenderung meningkat di pagi hari karena pelepasan hormon kortisol. Minum obat di pagi hari dapat membantu mengendalikan lonjakan tekanan darah di pagi hari. Namun, untuk beberapa individu yang tekanan darahnya cenderung meningkat di malam hari, minum obat di malam hari dapat memberikan dampak yang lebih signifikan dalam menurunkan tekanan darah." +
                        "Secara umum hingga saat ini penelitian belum dapat membuktikan manfaat waktu minum obat hipertensi pada malam hari dibanding pagi hari maupun sebaliknuya. Namun waktu yang optimal untuk minum obat hipertensi dapat ditentukan dengan diskusi bersama penyedia layanan kesehatan, mempertimbangkan berbagai faktor tiap individu seperti jenis dan mekanisme obat, tingkat tekanan darah, dan ritme sirkadian individu. Yang lebih penting adalah untuk meminum obat hipertensi secara tepat waktu dan sesuai dosis yang dianjurkan oleh dokter anda."
            ),
            ListArticle(
                11,
                name = "Perbandingan Efektivitas Olahraga Aerobik, Resistensi,  Kombinasi Keduanya pada Faktor Resiko Penyakit Jantung & Pembuluh Darah",
                publish = "dr. Muhamad Lodra Peta - RS Jantung dan Pembuluh Darah Harapan Kita Jakarta",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1701848553_134367.jpg",
                publishDate = "06 Desember 2023",
                description = "Kita hidup dizaman yang serba cepat dan instan saat ini, di mana gaya hidup yang kurang aktif dan pilihan makanan-makanan dengan kandungan gizi yang kurang baik ( seperti Junk food ) sangat mudah  untuk di dapat karena proses yang cepat. Penyakit kardiovaskular (PKV) telah muncul sebagai masalah kesehatan utama. Hipertensi, atau tekanan darah tinggi, merupakan faktor risiko utama untuk terjadinya PKV. Namun, modifikasi gaya hidup, seperti olahraga, telah terbukti efektif untuk menurunkan tekanan darah dan meningkatkan kesehatan jantung secara keseluruhan.\n" +
                        "\n" +
                        "Sementara olahraga aerobik telah lama diketahui memiliki banyak manfaat kesehatan. Peran olahraga Resistensi / ketahanan fisik dalam dunia kesehatan masih belum banyak di teliti. Akhir-akhir ini banyak penelitian terbaru yang mulai menyelidiki  manfaat dari menggabungkan olahraga aerobik dan resistensi. Artikel ini menjelajahi penelitian seputar kombinasi latihan dan khasiatnya pada resiko PKV. seperti tekanan darah, komposisi tubuh, dan kesehatan jantung dan pembuluh darah.\n" +
                        "\n" +
                        "Pentingnya Olahraga dalam Kesehatan Kardiovaskular\n" +
                        "\n" +
                        "Sebelum memasuki detail kombinasi latihan, penting untuk memahami pentingnya olahraga dalam menjaga kesehatan kardiovaskular. Aktivitas fisik teratur telah terbukti memiliki banyak manfaat, termasuk mengurangi risiko PKV, meningkatkan kesehatan  kardiovaskular, mengelola berat badan, dan meningkatkan kesejahteraan secara keseluruhan.\n" +
                        "\n" +
                        "American College of Sports Medicine (ACSM) dan American Heart Association (AHA) merekomendasikan olahraga teratur bagi orang dewasa, terutama mereka yang menderita hipertensi. Panduan ini menekankan pentingnya olahraga aerobik, seperti berjalan cepat, jogging, atau bersepeda, untuk meningkatkan kesehatan kardiovaskular. Namun, penelitian terbaru juga  telah melihat  manfaat olahraga resistensi pada populasi resiko penyakit kardiovaskular.\n" +
                        "\n" +
                        "Peran Olahraga Resistensi dalam Kesehatan Kardiovaskular\n" +
                        "\n" +
                        "Olahraga resistensi, yang dikenal dengan angkat beban atau latihan kekuatan, biasanya  dikaitkan dengan peningkatan kekuatan otot dan komposisi tubuh. Namun, bukti baru menunjukkan bahwa olahraga resistensi juga dapat memiliki efek positif pada kesehatan kardiovaskular.\n" +
                        "\n" +
                        "Beberapa penelitian telah menunjukkan bahwa olahraga resistensi dapat menurunkan tekanan darah, terutama tekanan darah diastolik. Penurunan ini sebanding dengan didapatkan pada  olahraga aerobik. Latihan resistensi juga terbukti meningkatkan komposisi tubuh dengan meningkatkan massa tubuh ( massa otot ) yang kurus dan mengurangi massa lemak.\n" +
                        "\n" +
                        "Selain efeknya pada tekanan darah dan komposisi tubuh, olahraga resistensi juga ditemukan meningkatkan kesehatan  kardiovaskular. Sementara olahraga aerobik utamanya meningkatkan kesehatan kardiorespirasi, olahraga resistensi telah terbukti meningkatkan kekuatan otot dan daya tahan, yang secara tidak langsung dapat bermanfaat bagi kesehatan kardiovaskular.\n" +
                        "Potensi Latihan Kombinasi\n" +
                        "\n" +
                        " Meskipun baik olahraga aerobik maupun resistensi memiliki manfaat bagi individu pada kesehatan kardiovaskular. Penelitian terbaru telah meneliti efek sinergis potensial dari menggabungkan kedua modalitas ini. Latihan kombinasi ini melibatkan penggabungan olahraga aerobik dan resistensi ke dalam program latihan yang komprehensif.\n" +
                        "\n" +
                        "Penelitian menunjukkan bahwa latihan kombinasi dapat menurunkan resiko penyakit kardio vascular lebih besar dibandingkan dengan olahraga aerobik atau resistensi saja. Sebuah studi yang dilakukan pada orang dewasa berusia pertengahan yang menderita tekanan darah tinggi dan gaya hidup kurang aktif menemukan bahwa program latihan kombinasi selama 8 minggu menghasilkan penurunan yang signifikan pada tekanan darah diastolik, meningkatkan kesehatan  kardiorespirasi, kekuatan otot, dan massa tubuh.\n" +
                        "\n" +
                        "Olahraga aerobik utamanya meningkatkan kesehatan kardiorespirasi dan komponen metabolik, sedangkan olahraga resistensi meningkatkan kekuatan otot, komposisi tubuh, dan kepadatan tulang. Dengan menggabungkan kedua olahjraga  ini, individu mendapatkan olahraga yang komprehensif untuk mencegah terjadinya penyakit kardiovaskular.\n" +
                        "\n" +
                        "Merancang Program Latihan Kombinasi yang Efektif\n" +
                        "\n" +
                        "Untuk merancang program latihan kombinasi yang efektif, penting untuk mempertimbangkan prinsip-prinsip preskripsi latihan, termasuk frekuensi, intensitas, waktu, dan jenis. ACSM dan AHA merekomendasikan setidaknya 150 menit olahraga aerobik intensitas sedang atau 75 menit olahraga aerobik intensitas tinggi per minggu, bersama dengan dua hari atau lebih latihan resistensi yang menargetkan kelompok otot utama.\n" +
                        "\n" +
                        "Dalam program latihan kombinasi, individu dapat membagi waktu latihan mereka antara latihan aerobik dan resistensi. Misalnya, seseorang bisa melakukan 30 menit olahraga aerobik, seperti berjalan cepat atau bersepeda, dan 30 menit latihan resistensi, fokus pada latihan seperti squats, lunges, dan chest presses. Pemilihan latihan dan intensitas yang spesifik harus disesuaikan dengan preferensi individu, tingkat kesehatan, dan tujuan.\n" +
                        "\n" +
                        "Manfaat Latihan Kombinasi\n" +
                        "\n" +
                        "Latihan kombinasi menawarkan olahraga yang komprehensif  bagi kesehatan kardiovaskular dengan menggabungkan latihan aerobik dan resistensi. Efek sinergis dari kedua modalitas ini dapat menghasilkan menurunkan resiko penyakit kardiovaskular.\n" +
                        "\n" +
                        "Manfaat dari latihan kombinasi meliputi:\n" +
                        "\n" +
                        "Penurunan Tekanan Darah: Latihan kombinasi telah terbukti secara signifikan menurunkan tekanan darah diastolik, yang dapat mengurangi risiko hipertensi dan PKV.\n" +
                        "Peningkatan Komposisi Tubuh: Latihan kombinasi dapat menuruknan berat badan, \n" +
                        ""
            ),
            ListArticle(
                12,
                name = "Pelayanan Fisioterapi Berbasis Home Care bagi Pasien Stroke",
                publish = "Tiara Zuhrat Shabrina Yophaputri, S.Ft., Ftr. - RSUP dr. Sardjito Yogyakarta",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1701327347_111292.png",
                publishDate = "18 Desember 2020",
                description = "Menurut WHO stroke didefinisikan suatu gangguan fungsional otak yang terjadi secara mendadak dengan tanda dan gejala klinis baik lokal maupun global yang berlangsung lebih dari 24 jam, atau dapat menimbulkan kematian, disebabkan oleh gangguan peredaran darah otak. Stroke saat ini tidak hanya dialami oleh orang lanjut usia saja, melainkan golongan remaja akhir dan dewasa juga beresiko terkena stroke. Faktor-faktor yang mempengaruhi resiko terjadinya stroke antara lain hipertensi, kadar kolesterol, merokok, diabetes melitus, konsumsi alkohol, obesitas, life style, dan stress.\n" +
                        "\n" +
                        "Stroke merupakan penyebab disabilitas nomor satu dan penyebab kematian nomor dua di dunia. Gangguan akibat stroke seringkali menimbulkan gejala sisa berupa kecacatan menetap sehingga mengakibatkan keterbatasan fungsi dalam melakukan aktivitas sehari-hari. Stroke pada umunya mengakibatkan gangguan motorik, yang biasanya mempengaruhi kontrol gerakan pada wajah, lengan, atau kaki dari satu sisi tubuh. Disfungsi motorik dapat mempengaruhi kemampuan penderita untuk melakukan aktivitas sehari-hari dan menyebabkan ketergantungan \n" +
                        "pada orang lain. Kecacatan lebih lanjut akan berakibat pada penurunan fungsi dan partisipasi sosial.\n" +
                        "\n" +
                        "Dalam proses pemulihan  sangat diperlukan tindakan fisioterapi secara intens pada anggota tubuh yang lumpuh. Fungsi fisioterapi sebagai rehabilitasi antara lain untuk menguji kebutuhan pasien, merencanakan pelayanan fisioterapi, mengevaluasi hasil pelayanan fisioterapi, bekerja sama dengan pasien dan keluarganya, serta memulihkan kapasitas fisik dan kemampuan fungsional. Tujuannya adalah untuk mengurangi komplikasi, mengembalikan fungsi dan memberikan pasien dengan strategi untuk mengatasi kondisi pasien agar mereka dapat kembali beraktivitas di lingkungan terdekat. Proses penyembuhan dan rehabilitasi pada penderita stroke dapat terjadi dalam waktu yang lama, yang membutuhkan kesabaran pasien dan keluarga. Rutinitas menjalani pengobatan di rumah sakit seringkali memakan waktu dan tenaga, sehingga program fisioterapi berbasis home care dapat menjadi solusi.\n" +
                        "\n" +
                        "Home care adalah suatu pelayanan yang bertujuan untuk meningkatkan, mempertahankan, atau memaksimalkan tingkat kemandirian dan meminimalkan akibat dari penyakit. Perawatan dengan setting rumah atau perawatan di tempat tinggal penderita ternyata memberikan dampak positif bagi tingkat kesembuhan dan rehabilitasi. Suatu penelitian yang dilakukan di Kanada menunjukkan bahwa pasien stroke akut yang diberikan pemulangan awal perawatan di rumah sakit dan dilanjutkan dengan program rehabilitasi di rumah mengalami kondisi kesehatan fisik yang lebih baik dan dapat bergabung kembali dengan komunitas dalam tiga bulan.\n" +
                        "\n" +
                        "Perawatan berbasis home care menawarkan keuntungan tambahan berupa kenyamanan berada di rumah. Selain itu, perawatan diberikan sesuai dengan skenario kehidupan nyata sehingga penderita dapat beradaptasi dengan keterbatasan yang dialami. Program fisioterapi akan berfokus pada mengontrol kekakuan (spastisitas), latihan penguatan, mobilisasi sendi, re-edukasi neuromuskular, latihan untuk berpindah tempat dan beraktivitas, mulai dari berguling, tidur ke duduk, duduk ke berdiri latihan jalan, serta penggunaan alat bantu seperti kursi roda, walker, dan tongkat sesuai dengan kebutuhan dan kondisi lingkungan terdekat pasien.\n"
            ),
            ListArticle(
                13,
                name = "Waspada Diabetes Militus pada Usia Muda, Kenali Gejala dan Faktor Risikonya",
                publish = "A A Istri Putri Wahyuni, SKM, MM - RSUP Prof. dr. I.G.N.G. Ngoerah",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1701327347_111292.png",
                publishDate = "30 November 2023",
                description = "Dulu kita menganggap bahwa diabetes militus atau kencing manis adalah penyakit yang diderita oleh orang yang berusia diatas 60 tahun atau Lansia, namun belakangan ternyata anggapan itu tidak sepenuhnya benar ya Sobat Sehat.  Nyatanya diabetes militus juga bisa diderita oleh orang usia muda bahkan anak-anak, jadi tidak ada batasan usia untuk bisa menderita penyakit ini. \n" +
                        "\n" +
                        "Diabetes militus adalah salah satu penyakit kronis yang ditandai dengan tingginya kadar gula di dalam darah akibat organ pangkreas tidak mampu memproduksi insulin, dimana hormon insulin inilah yang berfungsi mengendalikan kadar gula darah.  Kadar gula  yang menumpuk di dalam darah dan jaringan tidak bisa diserap oleh sel tubuh dengan baik dan dapat keluar melalui urine sehingga urine atau kencing penderita menjadi manis, karena itulah disebut penyakit kencing manis. Secara umum diabetes dapat dibagi menjadi 3 jenis yaitu, diabetes tipe 1, diabetes tipe 2, dan diabetes masa kehamilan.  Diabetes tipe 1 dikenal juga dengan diabetes autoimun, dimana sistem kekebalan tubuh menyerang dan menghancurkan pankreas yang memproduksi insulin.  Diabetes tipe 2 disebabkan oleh sel-sel tubuh menjadi kurang sensitif terhadap insulin, sehingga insulin yang dihasilkan tidak dapat dipergunakan dengan baik.  Tahukah Sobat Sehat bahwa sebagian besar kasus diabetes di Indonesia merupakan kasus diabetes tipe 2 yang disebabkan oleh gaya hidup yang kurang sehat, misalnya pola konsumsi tinggi gula dan lemak, kurang aktivitas fisik, kegemukan, dan merokok. \n" +
                        "\n" +
                        "Sudah seharusnya bagi kita mewaspadai timbulnya penyakit ini, salah satunya adalah dengan mengenali faktor risiko dan gejala-gejala yang muncul sedini mungkin sehingga dapat melakukan antisipasi dan penanganan yang tepat serta mencegah timbulnya komplikasi.  Gejala-gejala diabetes pada usia muda sejatinya tidak jauh berbeda dengan usia lainnya, berikut ini gejala-gejala diabetes di usia muda yang perlu diwaspadai:\n" +
                        "\n" +
                        "Sering buang air kecil, terutama di malam hari\n" +
                        "Sering merasa haus\n" +
                        "Lebih cepat lapar\n" +
                        "Penurunan berat badan tanpa sebab yang jelas\n" +
                        "Pandangan kabur\n" +
                        "Tubuh mudah lelah dan lemas\n" +
                        "Bercak kulit gelap di lipatan leher atau ketiak\n" +
                        "Luka sulit sembuh\n" +
                        "Mudah mengalami infeksi, misalnya sariawan\n" +
                        "Selain gejala-gejala seperti tersebut diatas, ada kondisi tertentu yang dapat berisiko bagi seseorang mengalami diabetes yang juga tidak kalah pentingnya untuk diwaspadai.  Faktor-faktor risiko tersebut ada yang dapat dikendalikan ada juga yang tidak, yang dapat dikendalikan atau dirubah antara lain:\n" +
                        "\n" +
                        "·         Kegemukan (Berat badan lebih /IMT > 23 kg/m2) dan Lingkar Perut (Pria > 90 cm dan Perempuan > 80cm)\n" +
                        "\n" +
                        "·         Kurang aktivitas fisik\n" +
                        "\n" +
                        "·         Dislipidemia (Kolesterol HDL ? 35 mg/dl, trigliserida ?250 mg/dl\n" +
                        "\n" +
                        "·         Riwayat penyakit jantung\n" +
                        "\n" +
                        "·         Hipertensi/ Tekanan darah Tinggi  (> 140/90 mmHg)\n" +
                        "\n" +
                        "·         Diet tidak seimbang (tinggi gula, garam, lemak dan rendah serat)\n" +
                        "\n" +
                        "Sedangkan faktor risiko yang tidak dapat dikendalikan sebagai penyebab diabetes militus, yaitu:\n" +
                        "\n" +
                        "·         Usia ?40 tahun\n" +
                        "\n" +
                        "·         Mempunyai riwayat keluarga menderita DM\n" +
                        "\n" +
                        "·         Kehamilan dengan gula darah tinggi\n" +
                        "\n" +
                        "·         Ibu dengan riwayat melahirkan bayi dengan (Berat Badan Lahir) > 4 kg\n" +
                        "\n" +
                        "·         Bayi yang memiliki Berat Badan Lahir (BBL) < 2>\n"
            ),
            ListArticle(
                14,
                name = "Ayo Bergerak, Cegah Obesitas",
                publish = "Ika Wijayanti, S. Ftr., Ftr. - RSUP dr. Sardjito Yogyakarta",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1701327130_445361.png",
                publishDate = "30 November 2023",
                description = "Data WHO pada tahun 2019 sebanyak 39% orang dewasa berusia 18 tahun ke atas mengalami kelebihan berat badan, dan 13% mengalami obesitas. anak dibawah usia 5 tahun sebanyak 41 juta mengalami kelebihan berat badan dan obesitas. Di Indonesia sebanyak 13,5% orang dewasa diatas 18 tahun mengalami kelebihan berat badan dan 28,7% obesitas sedangkan pada anak usia 5-12 tahun 18,8% kelebihan berat badan dan 10,8% obesitas.\n" +
                        "\n" +
                        "Obesitas adalah penumpukan lemak yang berlebihan akibat ketidak seimbangan asupan energi dengan energi yang digunakan dalam waktu lama. Adapun klasifikasi obesitas didapat dari perhitungan Body Mass Index (BMI) range, dimana BMI normal menurut kemenkes RI adalah 18,5 - 25. Faktor penyebab obesitas antara lain genetik, pola makan tinggi lemak trans dan gula, kurangnya aktivitas fisik/ malas bergerak, obat-obatan dan gangguan hormonal. Obesitas berdampak pada peningkatan kolesterol dan tekanan darah, selain itu juga menyebabkan perburukan asma, radang sendi lutut, pembentukan batu empedu, henti nafas saat tidur, dan nyeri pinggang. Prinsip mengatasi obesitas yaitu dengan mengatur keseimbangan energi yang masuk lebih rendah daripada yang dibutuhkan (defisit kalori) yang dapat diatur dengan pengaturan pola makan dan aktivitas fisik serta istirahat yang cukup.\n" +
                        "\n" +
                        "Penurunan berat badan secara drastis akan menyebabkan perubahan struktur, fisiologis dan psikologis tubuh termasuk perubahan mood dan hormonal sehingga dosis latihan dan porsi makan harus sesuai dari saran tenaga ahli medis yaitu fisioterapi dan ahli gizi. Obesitas dalam jangka waktu lama akan merubah strukur otot dan persendian sehingga lebih beresiko mengalami cedera saat berolahraga, maka disarankan untuk melakukan peregangan/ stretching dan pemanasan sebelum berolahraga serta pendinginan setelahnya. Untuk mencegah dehidrasi selama berolahraga pastikan minum air cukup sebelumnya dan bernafas melalui hidung bukan lewat mulut saat berolahraga. Mempertahankan penurunan berat badan lebih sulit daripada mendapatkan artinya konsisten menjadi hal yang utama untuk mempertahankan penurunan berat badan yang telah diperoleh. Hanya 20% orang yang mengalami kelebihan berat badan yang berhasil untuk mempertahankan 10?ri penurunan berat badan yang sudah didapat.\n" +
                        "\n" +
                        "Dosis latihan rekomendasi dari American Heart Association dan WHO untuk berolahraga secara konsisten 150 menit/ minggu latihan intensitas sedang masih kurang memadai untuk penurunan berat badan yang signifikan (<5>DOMS ( Delayed Onset Muscle Soreness) yang ditandai dengan pegal-pegal dan nyeri otot 12-24 jam setelah berolahraga.\n" +
                        "\n" +
                        "Latihan intensitas sedang setara dengan 3 - 6 METs (Metabolic Equivalent of Task(s)) atau 64 - 76?ri denyut jantung maksimal (220 - usia). Untuk orang awam dosis latihan sedang yaitu jika saat latihan seseorang tidak dapat mengucapkan 3 kata berturut-turut tanpa menarik nafas. Contoh latihan dosis sedang yaitu berjalan sedang hingga cepat, berenang dengan kecepatan sedang, menari, kegiatan rumah dan berkebun. Dosis latihan tersebut akan memberikan hasil penurunan berat badan yang signifikan jika dilakukan secara konsisten minimal 10 minggu dan terus berlanjut sampai berat badan ideal didapatkan. Setelah mencapai berat badan ideal dosis latihan intensitas sedang sesuai standar WHO 150 menit/ minggu untuk mempertahankan berat badan ideal dengan tetap menjaga pola makan sehat serta istirahat cukup.\n"
            ),
            ListArticle(
                15,
                name = "Camilan Sehat Bagi Penderita Diabetes",
                publish = "Vina Puji Rahayu - RS Jiwa Prof.Dr.Soeroyo Magelang\n",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1658975920_642437.jpg",
                publishDate = "28 Juli 2022",
                description = "Diabetes dapat dialami oleh siapa saja dan tidak memandang usia. Terlebih lagi diabetes dapat terjadi karena faktor keturunan. Memiliki gula darah yang tinggi artinya harus membatasi asupan makanan yang kita komsumsi agar kesehatan tubuh terjaga.\n" +
                        "\n" +
                        "Bagi penderita diabetes tentunya memiliki tantangan tersendiri dalam memilih makanan yang akan dikomsumsi. Karena apabila tidak hati-hati dalam memilih makanan maka akan mengakibatkan gula darah semakin tinggi atau rendah. Kuncinya adalah, pilihlah makanan yang mengandung serat yang tinggi, protein, dan  lemak sehat agar dapat membantu mengendalikan kadar gula darah.\n" +
                        "\n" +
                        "Berikut ini terdapat beberapa contoh makanan atau camilan yang bisa kamu masukkan kedalam daftar pilihan makanan sehatmu, antara lain:\n" +
                        "\n" +
                        "1.    Telur Rebus\n" +
                        "\n" +
                        "Telur dapat diolah menjadi berbagai jenis masakan, salah satunya dengan cara direbus. Selain rasanya yang enak, telur juga bisa dikomsumsi oleh orang yang menderita diabetes. Dalam 1 butir telur rebus mengandung 6 gram protein yang sangat bermanfaat bagi tubuh. Kandungan protein yang ada pada telur tidak mengakibatkan kadar gula darah melonjak dengan cepat. Selain itu telur juga mengandung biotin dan asam lemak omega-3 yang dapat membantu mengurangi peradangan dan mencegah komplikasi dari penyakit diabetes.\n" +
                        "\n" +
                        "2.    Apel\n" +
                        "\n" +
                        "Kamu bisa memilih apel untuk dijadikan camilan sehatmu karena apel aman dikonsumsi oleh penderita diabetes. Selain memiliki rasa yang manis, apel juga mengandung vitamin A, C serta rendah kalori. Antioksidan yang terkandung didalamnya juga berfungsi untuk mencegah berbagai macam penyakit.  Kamu bisa mengonsumsi apel sebagai camilan atau bisa juga ditambahkan dengan selai kacang. Apel juga mengandung serat tinggi yang dapat menahan rasa lapar lebih lama. Apabila dikonsumsi sebelum makan maka akan berguna sebagai pengontrol kalori.\n" +
                        "\n" +
                        "3.    Alpukat\n" +
                        "\n" +
                        "Alpukat dikenal dengan salah satu buah yang mengandung lemak tak jenuh yang baik untuk kesehatan jantung dan kontrol gula darah. Alpukat juga mengandung serta yang tinggi. Dalam 1 buah alpukat mengandung sekitar 13 gram serat. \n" +
                        "Alpukat dapat dikonsumsi secara langsung atau bisa dijadikan sebagai dressing salad.\n" +
                        "\n" +
                        "4.    Kacang Almond\n" +
                        "\n" +
                        "Kacang almond merupakan camilan yang lezat dan bergizi. Dalam 1 porsi (28 gram) terdapat lebih dari 15 vitamin dan mineral yang dapat membantu mengontrol diabetes. Manfaat lain dari kacang almond adalah mampu mengurangi resistensi insulin, mengontrol kadar gula darah, dan menyehatkan jantung. Namun kacang almond memiliki kalori yang tinggi, oleh karena itu kamu harus membatasinya dengan cukup mengonsumsi segenggam per hari.\n" +
                        "\n" +
                        "5.    Kacang Kedelai (edamame)\n" +
                        "\n" +
                        "Kacang kedelai baik dikonsumsi oleh penderita diabetes. Dalam 1 porsi (150 gram)terdapat sekitar 17 gram protein dan 8 gram serat. Kedua kandungan tersebut bermanfaat untuk mengontrol kadar gula darah dan filtrasi ginjal. Kamu bisa mengolah edamame dengan cara direbus atau dikukus sebagai camilan sehatmu.\n" +
                        "\n" +
                        "6.    Yoghurt Rendah Lemak\n" +
                        "\n" +
                        "Yoghurt dikenal sebagai makanan yang baik untuk kesehatan pencernaan. Selain itu yoghurt juga memiliki kandungan probiotik tinggi yang mampu meningkatkan kemampuan tubuh dalam proses pemecahan makanan yang mengandung gula. Saat proses metabolisme gula diolah baik oleh tubuh maka kadar gula dalam darah akan berkurang.  Namun pastikan kamu memilih yoghurt dengan rasa tawar atau plain. Hindari memilih yoghurt dengan perasa atau pemanis tambahan. Kamu bisa mengonsumsinya secara langsung atau bisa menambahkan buah strawberry yang menyehatkan.\n"
            ),
            ListArticle(
                16,
                name = "Beberapa Sumber Makanan Sehat",
                publish = "Aidiawaty,S.Kep.Ns - RSUP dr. Mohammad Hoesin Palembang",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1658900467_92499.jpg",
                publishDate = "27 Juli 20220",
                description = "Sehat adalah nikmat Allah yang sangat patut kita syukuri, salah satu cara mensyukurinya adalah dengan menjaga kesehatan dengan cara mengkonsumsi makanan sehat dan bergizi,salah satunya adalah buah-buahan dan sayuran..Selain jenis jenis protein yang banyak mengandung nilai gizi yang tinggi seperti daging, ayam, telur dsb, buah direkomendasikan untuk mencukupi kebutuhan nilai gizi. Buah selain sebagai sumber serat, vitamin serta mineral, buah juga mempunyai rasa yang enak dan manis, ada juga buah dengan sensasi rasa asam dan pahit, tetapi tidak mengurangi penikmat buah untuk memakannya dengan mempertimbangkan beberapa manfaat dari kandungan buah tersebut.\n" +
                        "\n" +
                        "We Are What We Eat, Kebanyakan kita tidak tahu apa makna sehat dan dari mana sehat itu berawa.\n" +
                        "\n" +
                        "Berikut beberapa buah-buahan dan makanan yang baik untuk dikonsumsi :\n" +
                        "1. Pisang\n" +
                        "\n" +
                        "  Mencegah dan menyembuhkan tukak\n" +
                        "Menurut beberapa penelitian pisng dapat mencegah dan mempercepat penyembuhan tukak lambung. Pisang juga mengandung sejumlah nutrient yang penting untuk menstabilkan saluran gastrointestinal dan memperkuat sel-sel permukaan lambung, jadi menciptakan semacam barrier yang tebal terhadap asam pencernaan dan pepsin-\n" +
                        "\n" +
                        "----dua unsur utama penyebab tukak lambung.\n" +
                        "\n" +
                        "  Menurunkan tekanan darah\n" +
                        "Pisang banyak mengandung Kalium dan hampir tidak mengandung Natrium. Kalium berperan mengendalikan tekanan darah. Pemberian obat darah tinggi berefek samping menurunkan kadar kalium sampai tingkat yang berbahaya, oleh karena itu beberapa pasien dimimta juga untuk memakan pisang.\n" +
                        "\n" +
                        "  Menurunkan kolesterol\n" +
                        "Kandungan serat dalam pisang juga baik untuk jantung karena menurunkan kadar kolesterol darah. Kandungan serat pektin dalam pisang yang berperan menurunkan kolesterol darah.\n" +
                        "\n" +
                        "  Menghilangkan PMS (Premenstrual Syndrome)\n" +
                        "Pisang mengandung cukup banyak vitamin C dan B6, yang menjadikannya pilihan yang baik untuk wanita yang sedang PMS.\n" +
                        "\n" +
                        "  Sumber energi bagi lansia\n" +
                        "Pisang melawan rasa lapar dan memberikan rasa kenyang yang menyenangkan. \nKombinasi fruktosa alami dan serat memberikan posisi superstar bagi pisang.\n" +
                        "\n" +
                        "Pilihlah pisang yang sudah matang untuk dimakan, Semakin matang pisang, rasanya akan semakin manis. Pisang yang masih hijau atau belu masak memiliki kandungan zat tepung yang banyak yang sulit dicerna, tetapi saat pisang semakin matang, zat tepung ini berubah menjadi gula alami penghancur lemak yang lebih mudah dicerna.\n" +
                        "2.Apel\n" +
                        "\n" +
                        " Menurunkan Kolesterol dan tekanan darah\n" +
                        "Apel mengandung serat pektin, serat yang larut dalam air yang menurunkan kadar kolesterol LDL yang dapat menyumbat pembuluh darah. Pada saat yang sama pektin menaikkan kadar HDL atau kolesterol baik. Tingkat HDL yang tinggi juga dikaitkan dengan risiko penyakit jantung yang rendah.\n" +
                        "\n" +
                        "Pektin membatasi jumlah lemak yang dapat diserap oleh seladiposa (sel lemak) dengan membangun sebuah “barrier” yang secara alami mengendalikan penumpukan lemak di dalam tubuh.\n" +
                        "\n" +
                        "Apel juga merupakan sumber serat larut yang paling baik, karena tidak mengandung lemak, kolesterol dan Natrium.\n" +
                        "\n" +
                        " Membantu Pencernaan\n" +
                        "Apel kaya akan serat yang dinamakan “roughage” yang membantu pergerakan saluran pencernaan. Apel juga dapat menghilangkan diare. Pektin adalah bahan yang terkandungdalam obat anti diare Kaopectate\n" +
                        "\n" +
                        " Menstabilkan gula darah\n" +
                        "Kandungan serat yang tinggi di sebuah apel membantu gula darah stabil, dan kadar gula darah yang seimbang dapat mengendalikan nafsu makan anda.\n" +
                        "\n" +
                        " Bekerja sebagai “sikat gigi’ alami\n" +
                        "Menguyah sebuah apel seperti menggunakan sikat gigi alami, apel dapat membersihkan makanan yang tersembunyi dibelakang gigi dan gusi sehingga menghalangi terjadinya karies gigi dan penyakit gusi. Kandungan vitamin C yang tinggi di dalam apel dapat membantu penderita penyakit gusi seriuas.\n" +
                        "\n" +
                        " Membantu menurunkan Berat Badan (BB)\n" +
                        "Apel memiliki kandungan Kalium yang tinggi. Kalium mambantu tubuh membuang natrium. Jika tubuh tidak mendapatkan cukup kalium, natrium akan membuat tubuh menahan cairan, yang artinya akan terjadi peningkatan berat badan.\n" +
                        "3.. Nanas\n" +
                        "\n" +
                        "  Membantu menghilngkan lemak dari tubuh\n" +
                        "Nanas mengandung protein bromelain. Protein ini memiliki potensi yang sama dengan pepsin yang ditemukan pada pepaya. Bromelain membantu melarutkan pembentukan mukus dan juga mempercepat pembuangan lemak melalui ginjal. Bromelain juga memiliki asam sitrat dan malat yang penting yang diperluksn untuk memperbaiki\n"
            ),
            ListArticle(
                17,
                name = "Makanan Sehat untuk Penderita Kolesterole",
                publish = "Tim Promkes RSST - RSUP dr. Soeradji Tirtonegoro Klaten",
                imageUrl = "https://yankes.kemkes.go.id/img/bg-img/gambarartikel_1658909841_529360.png",
                publishDate = "18 Desember 2020",
                description = "Bagi Anda yang memiliki kadar kolesterol tinggi, maka harus memperhatikan setiap makanan yang hendak dikonsumsi. Selain ada pantangan yang harus dihindari, ada juga anjuran makanan penurun kolesterol tinggi yang baik untuk dikonsumsi bahkan bisa dijadikan sebagai menu makanan sehari-hari. Jangan beranggapan bahwa kita tidak membutuhkan kolesterol, zat lemak ini tetap kita butuhkan dan memang sangat penting untuk kehidupan, namun jika ada terlalu banyak kolesterol dalam darah kita, maka dapat merusak kesehatan terutama yang terkait dengan aliran darah pada organ-organ vital seperti jantung dan otak. Untuk itu selain menggunakan obat penurun kolesterol, kita juga harus memperhatikan apa saja makanan untuk penderita kolesterol tinggi yang boleh dikonsumsi serta ada juga berbagai pilihan makanan sehat yang diketahui mampu mengurangi dan mengontrol kadar kolesterol dalam darah.\n" +
                        "\n" +
                        "Makanan Sehat untuk Penderita Kolesterol Tinggi\n" +
                        "\n" +
                        "Untuk menurunkan kadar kolesterol dalam darah, ada beberapa jenis makanan sehat yang baik dikonsumsi oleh penderita kolesterol, di antaranya :\n" +
                        "\n" +
                        "1.       Sayuran dan Buah-buahan\n" +
                        "\n" +
                        "Sayuran dan buah-buahan merupakan kelompok makanan sehat kaya nutrisi yang baik dikonsumsi oleh penderita kolesterol. Kandungan serat, vitamin, dan mineral di dalamnya dikenal baik untuk kesehatan tubuh dan mampu menurunkan kolesterol jahat (LDL). Beberapa jenis sayuran dan buah-buahan yang baik dikonsumsi oleh penderita kolesterol tinggi meliputi :\n" +
                        "\n" +
                        "·            Aneka sayuran, seperti : brokoli, bayam, sawi, selada, wortel, dan kentang.\n" +
                        "\n" +
                        "·            Buah dengan kandungan serat pektin, seperti : jeruk, apel, anggur, dan stroberi.\n" +
                        "\n" +
                        "2.       Ikan yang Mengandung Lemak Sehat\n" +
                        "\n" +
                        "Penderita kolesterol tinggi juga dianjurkan untuk mengonsumsi makanan yang mengandung asam lemak omega-3, seperti : ikan salmon, ikan kembung, ikan sarden, dan ikan tuna. Berbagai riset menunjukkan bahwa lemak sehat omega-3 diketahui baik untuk mengurangi kadar trigliserida dalam darah, menjaga kadar kolesterol baik (HDL), memelihara kesehatan jantung dan pembuluh darah, serta mengurangi risiko terjadinya penyakit kardiovaskuler, seperti penyakit jantung dan stroke.\n" +
                        "\n" +
                        "3.       Biji-bijian Utuh\n" +
                        "\n" +
                        "Biji-bijian, seperti : biji bunga matahari, gandum, dan chia seed, juga termasuk dalam jenis makanan sehat untuk penderita kolesterol tinggi. Jenis makanan ini kaya akan vitamin, mineral, protein, lemak sehat, antioksidan, serta serat larut yang disebut beta-glukan. Berkat beragam nutrisi dan serat di dalamnya, biji-bijian baik dikonsumsi untuk menurunkan kolesterol jahat (LDL) dan mengurangi penyerapan kolesterol di dalam saluran cerna.\n" +
                        "\n" +
                        "4.       Kacang-kacangan\n" +
                        "\n" +
                        "Tidak hanya biji-bijian, kacang-kacangan juga mengandung aneka nutrisi, serat, dan antioksidan yang baik dikonsumsi oleh penderita kolesterol tinggi. Beberapa jenis kacang-kacangan yang dapat dikonsumsi meliputi :\n" +
                        "\n" +
                        "·            Kacang polong, lentil, dan buncis dikenal sebagai sumber protein yang baik.\n" +
                        "\n" +
                        "·            Kacang kedelai dan edamame mengandung protein dan isoflavon yang terbukti dapat menurunkan kadar kolesterol jahat.\n" +
                        "\n" +
                        "·            Kacang almond dan kenari mengandung fitosterol dan terbukti menghambat penyerapan kolesterol jahat di dalam usus.\n" +
                        "\n" +
                        "5.       Jamur\n" +
                        "\n" +
                        "Jamur merupakan pilihan yang cocok sebagai makanan bebas kolesterol. Secara tersendiri jamur bisa menjadi makanan untuk penderita kolesterol tinggi asalkan tidak ada pencampuran bahan yang mengandung lemak dalam penyiapan ataupun penyajian.\n" +
                        "\n" +
                        "6.       Bawang Putih dan Bawang Merah\n" +
                        "\n" +
                        "Bawang putih akan menjaga darah agar bebas dari kolesterol jahat. Jika Anda ingin camilan lezat, Anda dapat didihkan seluruh siung bawang putih dalam minyak zaitun dan kemudian menyebarkannya di piring, kerupuk, roti atau makanan lain yang rendah kolesterol. Bawang merah, seperti halnya bawang putih, mengandung antioksidan. Bahan-bahan ini tentu saja akan menjadi bumbu dalam masakan baik berupa tumis, panggang, atau dimasak dengan cara lain, tapi bawang mentah memiliki kadar nutrisi tertinggi yang baik untuk jantung sehat.\n" +
                        "\n" +
                        "7.       Tahu\n" +
                        "\n" +
                        "Tahu bukanlah pilihan utama sebagai makanan untuk penderita kolesterol tinggi. Namun ketika itu dimasak dengan benar, dapat menjadi pengganti yang baik untuk daging di banyak hidangan. Tahu yang memiliki struktur seperti spons, dapat menyerap rempah-rempah, bumbu-bumbu dan menambah kekayaan hidangan serta menciptakan rasa enak dalam setiap hidangan.\n" +
                        "\n" +
                        "8.       Bayam\n" +
                        "\n" +
                        "Pilihan yang sangat baik ketika berbicara tentang makanan penurun kolesterol tinggi adalah bayam. Bayam memiliki banyak lutein, yang merupakan pigmen sinar matahari kuning yang ditemukan dalam kuning telur dan sayuran berdaun hijau gelap. Lutein memiliki reputasi besar dalam menjaga mata agar terhindar dari degenerasi makula, penyebab utama kebutaan. Disarankan hanya dengan mengonsumsi setengah cangkir makanan kaya lutein setiap hari agar tubuh terlindung terhadap serangan jantung dengan membantu dinding arteri melepaskan setiap kolesterol yang menyebabkan penyumbatan.\n" +
                        "\n" +
                        "9.       Alpukat\n" +
                        "\n" +
                        "Alpukat merupakan makanan sehat penurun kolesterol yang baik untuk jantung. Buah yang satu ini mengandung lemak tak jenuh tunggal yang dapat membantu meningkatkan kolesterol baik sambil menurunkan kadar kolesterol jahat, LDL. Alpukat juga memiliki beta-sitosterol, yang merupakan lemak nabati menurunkan kolesterol yang diserap dari makanan. Dengan kombinasi zat ini dengan lemak tak jenuh tunggal, alpukat merupakan makanan yang baik untuk penderita kolesterol tinggi.\n"
            )
        )
    }
}