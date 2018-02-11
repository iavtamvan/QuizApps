package com.sandec.iavariav.root.quizapps.rest;

import com.sandec.iavariav.root.quizapps.Model.SoalModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by idn on 8/12/2017.
 */

public interface ApiService {
    @GET("getsoal.php")
    Call<ArrayList<SoalModel>> getDataSoal();
//
//    @GET("DataSampahAPI")
//    Call<ArrayList<DataSampahModel>> ambilDataSampah();
//
//    @GET("SPBUAPI")
//    Call<ArrayList<SPBUModel>> ambilDataSPBU();
//
//    @GET("SaldoAPI")
//    Call<ArrayList<TabunganSaldoModel>> ambilDataTabunganSaldo();
//
//    @GET("UserAPI")
//    Call<ArrayList<UserModel>> ambilDataUser();
//
//    @GET("TransaksiMasukAPI")
//    Call<ArrayList<TransaksiMasukModel>> ambildatatransaksimasuk();
//
//    @GET("TransaksiKeluarAPI")
//    Call<ArrayList<TransaksiKeluarModel>> ambildatatransaksikeluar();
//
//
//    // TODO Register
//
//    @FormUrlEncoded
//    @POST("UserAPI") // TODO ini nanti di ganti yah
//    Call<ResponseBody> postRegister(
//            @Field("nama") String nama,// TODO sini di copy
//            @Field("alamat") String alamat,// TODO sini di copy
//            @Field("hp") String hp,// TODO sini di copy
//            @Field("email") String email,// TODO sini di copy
//            @Field("password") String password);//
//
//
//
//
//
//
//
//
//    @FormUrlEncoded
//    @POST("TransaksiMsukAPI") // TODO ini nanti di ganti yah
//    Call<ResponseBody> postTambahTransaksiMasuk(
//            @Field("IDUser") String iduser,
//            @Field("IDSPBU") String idspbu,
//            @Field("IDTeller") String idteller,
//            @Field("IDSampah") String idsampah,
//            @Field("Tanggal") String tgl,
//            @Field("JumlahSampah") String jml);
//
//    @FormUrlEncoded
//    @POST("TransaksiKeluarAPI") // TODO ini nanti di ganti yah
//    Call<ResponseBody> postPenukaranPertamax(
//            @Field("Pertamax") String pertamaxliter,
//            @Field("IDUser") String id,
//            @Field("Tgl") String tgl);//
//    @FormUrlEncoded
//    @POST("ProfileAPI") // TODO INI LINK NYA KAN MAS?
//    Call<ResponseBody> postProfil(
//            @Field("IDUser") String pertamaxliter,// TODO ini KEY nya yg di POSTMAN kan mas
//            @Field("Password") String id);//// TODO ini KEY nya yg di POSTMAN kan mas
}
