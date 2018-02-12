package com.sandec.iavariav.root.quizapps.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sandec.iavariav.root.quizapps.R;
import com.sandec.iavariav.root.quizapps.rest.ApiService;
import com.sandec.iavariav.root.quizapps.rest.Client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TambahSoalFragment extends Fragment {


    private EditText edtPertanyaan;
    private EditText edtOpta;
    private EditText edtOptb;
    private EditText edtOptc;
    private EditText edtOptd;
    private EditText edtOpte;
    private EditText edtJawaban;
    private EditText edtImage;
    private Button btnBatal;
    private Button btnTambahSoal;

    public TambahSoalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah_soal, container, false);
        edtPertanyaan = (EditText) view.findViewById(R.id.edt_pertanyaan);
        edtOpta       = (EditText) view.findViewById(R.id.edt_opta);
        edtOptb       = (EditText) view.findViewById(R.id.edt_optb);
        edtOptc       = (EditText) view.findViewById(R.id.edt_optc);
        edtOptd       = (EditText) view.findViewById(R.id.edt_optd);
        edtOpte       = (EditText) view.findViewById(R.id.edt_opte);
        edtJawaban    = (EditText) view.findViewById(R.id.edt_jawaban);
        edtImage      =  (EditText) view.findViewById(R.id.edt_image);
        btnBatal = (Button) view.findViewById(R.id.btn_batal);
        btnTambahSoal = (Button) view.findViewById(R.id.btn_tambah_soal);

        btnTambahSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = Client.getInstanceRetrofit();
                apiService.postTambahSoal(
                        edtPertanyaan.getText().toString().trim(),
                        edtOpta.getText().toString().trim(),
                        edtOptb.getText().toString().trim(),
                        edtOptc.getText().toString().trim(),
                        edtOptd.getText().toString().trim(),
                        edtOpte.getText().toString().trim(),
                        edtJawaban.getText().toString().trim(),
                        edtImage.getText().toString().trim()
                ).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                String error_msg = jsonObject.optString("error_msg");
                                Toast.makeText(getActivity(), "" + error_msg, Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }
}
