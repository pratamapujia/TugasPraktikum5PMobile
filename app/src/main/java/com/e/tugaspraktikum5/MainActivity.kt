package com.e.tugaspraktikum5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createJajan()
        rv_makanan.layoutManager = LinearLayoutManager(this)
        rv_makanan.setHasFixedSize(true)
        rv_makanan.adapter = adapter(testData, { fakItem: makanan -> resepItemClicked(fakItem)})
    }
    private fun resepItemClicked(Item: makanan) {
        val showDetailActivityIntent = Intent(this, makanan_detail::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, Item.NamaJajan.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, Item.DescJajan.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, Item.hargaJajan.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, Item.imgJajan.toString())
        startActivity(showDetailActivityIntent)
    }
    private fun createJajan() : List<makanan> {
        val partList = ArrayList<makanan>()
        partList.add(
            makanan("Sate Kelopo",
            "Makanan khas surabaya yang pertama adalah sate klopo. Dalam bahasa jawa klopo artinya kelapa, tetapi bukan berarti sate ini terbuat dari bahan dasar kelapa.\n\n" +
                "Sate klopo terbuat dari daging ayam atau daging sapi, yang dicampur dengan lemak atau jeroan sehingga rasanya lebih enak dan gurih.\n\n" +
                "Berbeda dengan sate pada umumnya, sebelum dibakar sate dilumuri dengan parutan kelapa.\n\n" +
                "Cara inilah yang membuat banyak orang menyebutnya dengan sate klopo. Taburan kelapa akan membuat rasa gurih di bakaran, aroma kelapa bakar pun membuat masakan semakin enak.\n\n" +
                "Anda bisa membeli sate klopo ini, di jalan walikota mustajab nomor 36 surabaya, tepat disebelah barat balai kota surabaya.",
                "Rp. 20.000",R.drawable.sate_kelopo))
        partList.add(
            makanan("Nasi Goreng Jancuk",
                "Dalam bahasa jawa surabaya, jancuk berarti sebuah umpatan. Tetapi kata ini malah dijadikan salah satu nama makanan khas surabaya yaitu nasi goreng jancuk.\n\n" +
                        "Sekilas nasi goreng ini memang mirip dengan nasi goreng lainnya. Dinamakan jancuk, karena trademark dari Chef eko purwanto dari Kartini Restaurant Surabaya Plaza Hotel.\n\n" +
                        "Karena rasanya yang pedas, panas dan enak membuat orang-orang yang memakannya ingin mengatakan jancuk.",
                "Rp. 15.000",R.drawable.sego_goreng_jancuk))
        partList.add(
            makanan("Pecel Semanggi",
                "Seperti namanya pecel ini terbuat dari bahan dasar daun semanggi. Di kota lain, pecel biasanya terbuat dari sawi, bayam atau bahan lainnya.\n\n" +
                        "Tetapi di surabaya anda bisa menikmati pecel yang beda dari lainnya. Semanggi membuat rasa pecel semakin enak, apalagi ada tambahan daun pepaya.\n\n" +
                        "Daun pepayanya tidak terasa pahit, dimakan dengan sambal pecel membuat perpaduan bahan ini semakin menggugah selera. Jangan lupa dengan kerupuknya, supaya semakin nikmat.",
                "Rp. 12.000",R.drawable.pecel_semanggi))
        partList.add(
            makanan("Kue Bikang",
                "Kue Bikang atau carabikang merupakan kue tradisional yang terbuat dari tepung beras dengan bentuk bunga yang merekah beraneka warna. Kue Bikang menjadi jajanan pasar khas Surabaya yang biasa disantap di pagi atau sore hari.\n\n" +
                        "Salah satu penjual kue bikang yang terkenal adalah Kue Bikang Peneleh yang berada di Jl Peneleh No.32-34, Peneleh, Kec. Genteng, Surabaya.\n\n" +
                        "Kue Bikang juga banyak ditemukan di pasar-pasar tradisional di Surabaya.",
                "Rp. 2.000",R.drawable.kue_bikang))
        partList.add(
            makanan("Cakue Peneleh",
                "Cakue merupakan salah satu jajanan yang banyak ditemui di Indonesia. Di Surabaya, ada salah satu cakue legendaris bernama cakue Peneleh. Yang membedakan Cakue Peneleh dengan cakue lain adalah adanya isiannya pada cakue ini.\n\n" +
                        "Cakue Peneleh bisa berisi cacahan ayam, daging, hingga udang. Cacahan daging ayam ataupun udang dimasukkan ke dalam belahan cakue kemudian digoreng sampai kering dan renyah.\n\n" +
                        "Cakue Peneleh bisa ditemukan di Pasar Atom Lama Jl. Bunguran No. 45, Bongkaran, Surabaya. Di sini juga tersedia roti goreng, kompyang, bikang dan banyak jajanan pasar lainnya.",
                "Rp. 5.000",R.drawable.cakue_peneleh))
        partList.add(
            makanan("Pentol Gila",
                "Camilan super pedas memang bikin tak mau bagi-bagi. Apalagi jika camilannya berupa pentol gila.\n\n" +
                        "Setelah buka di Jalan Gubeng Airlangga II No.9, outlet ini juga membuka cabang di Food Court Tunjungan Plaza 1. Selain disajikan dengan sambal super pedas, jajanan ini juga bisa disajikan bersama dengan nasi putih.\n\n" +
                        "Nama menunya disebut Nasi Petarung. Tak hanya menggoyang lidah, perut juga bakal kenyang banget.",
                "Rp. 5.000",R.drawable.pentol_gila))
        return partList
    }
}