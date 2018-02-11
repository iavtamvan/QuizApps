package com.sandec.iavariav.root.quizapps.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sandec.iavariav.root.quizapps.Adapter.SoalAdapter;
import com.sandec.iavariav.root.quizapps.Model.SoalModel;
import com.sandec.iavariav.root.quizapps.R;
import com.sandec.iavariav.root.quizapps.rest.ApiService;
import com.sandec.iavariav.root.quizapps.rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SoalFragment extends Fragment {
    RecyclerView rv_soal;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<SoalModel> listSoal;

    public SoalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal, container, false);
        rv_soal = view.findViewById(R.id.rv);
        listSoal = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_soal.setLayoutManager(layoutManager);



        ApiService apiService = Client.getInstanceRetrofit();
        Call<ArrayList<SoalModel>> call = apiService.getDataSoal();
        call.enqueue(new Callback<ArrayList<SoalModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SoalModel>> call, Response<ArrayList<SoalModel>> response) {
                listSoal = response.body();
                mAdapter = new SoalAdapter(getActivity(), listSoal);
                rv_soal.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
//                for (int i = 0; i <listSoal.size() ; i++) {
//                    String pertanyaan = listSoal.get(i).getPERTANYAAN();
//                    String opta = listSoal.get(i).getOPTA();
//                    String optb = listSoal.get(i).getOPTB();
//                    String optc = listSoal.get(i).getOPTC();
//                    String optd = listSoal.get(i).getOPTD();
//                    String opte = listSoal.get(i).getOPTE();
//                    String jawaban = listSoal.get(i).getJAWABAN();
//                    String img = listSoal.get(i).getIMG();


//                    SoalModel soalModel = new SoalModel(pertanyaan, opta, optb, optc, optd, opte, jawaban, img);
//                    listSoal.add(soalModel);
//                }
//                SoalAdapter soalAdapter = new SoalAdapter(getActivity(), listSoal);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                rv_soal.setLayoutManager(linearLayoutManager);
//                rv_soal.setAdapter(soalAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<SoalModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error Network", Toast.LENGTH_SHORT).show();
            }
        });

        // TODO sampai disini
        return view;
    }

}
