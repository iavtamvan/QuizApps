package com.sandec.iavariav.root.quizapps.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sandec.iavariav.root.quizapps.Model.SoalModel;
import com.sandec.iavariav.root.quizapps.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/3/18.
 */

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.ViewHolder> {
//    deklarasi variabel variabel
    Context context;
    List<SoalModel> listSoal;
    String jawabanValidasi;

    public SoalAdapter(Context context, ArrayList<SoalModel> listSoal) {
        this.context = context;
        this.listSoal = listSoal;
    }

    @Override
    public SoalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal, parent,false);
        return new ViewHolder(view);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_gambarSoal;
        TextView tv_pertanyaan ,tv_jawaban_validasi;
        RadioGroup rg_rbjawaban;
        RadioButton rb_opta, rb_optb, rb_optc, rb_optd, rb_opte;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_gambarSoal = itemView.findViewById(R.id.iv_gambarSoal);
            tv_pertanyaan = itemView.findViewById(R.id.tv_pertanyaan);
            rg_rbjawaban = itemView.findViewById(R.id.rg_rbjawaban);
            tv_jawaban_validasi = itemView.findViewById(R.id.tv_jawaban_validasi);
            rb_opta = itemView.findViewById(R.id.rb_opta);
            rb_optb = itemView.findViewById(R.id.rb_optb);
            rb_optc = itemView.findViewById(R.id.rb_optc);
            rb_optd = itemView.findViewById(R.id.rb_optd);
            rb_opte = itemView.findViewById(R.id.rb_opte);

        }
    }

    @Override
    public void onBindViewHolder(final SoalAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(listSoal.get(position).getIMG())
                .thumbnail(1f)
                .error(R.drawable.sandec)
                .into(holder.iv_gambarSoal);
        holder.tv_pertanyaan.setText(listSoal.get(position).getPERTANYAAN());
        holder.rb_opta.setText(listSoal.get(position).getOPTA());
        holder.rb_optb.setText(listSoal.get(position).getOPTB());
        holder.rb_optc.setText(listSoal.get(position).getOPTC());
        holder.rb_optd.setText(listSoal.get(position).getOPTD());
        holder.rb_opte.setText(listSoal.get(position).getOPTE());
        holder.tv_jawaban_validasi.setText(listSoal.get(position).getJAWABAN());
        jawabanValidasi = listSoal.get(position).getJAWABAN(); // ini belum fix
        holder.rg_rbjawaban.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioGroup.getId();
                Toast.makeText(context, "" + holder.rb_opta.getText().toString().trim(), Toast.LENGTH_SHORT).show();
//                if (holder.rb_opta.getText().toString() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                    Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
//                }
//                else if (holder.rb_optb.getText().toString() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                    Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
//                }
//                else if (holder.rb_optc.getText().toString() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                    Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
//                }
//                else if (holder.rb_optd.getText().toString() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                    Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
//                }
//                else if (holder.rb_opte.getText().toString() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                    Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
//                }
            }
        });


//        holder.rg_rbjawaban.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (holder.rb_opta.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                            Toast.makeText(context, "Jawaban Anda Benar" + holder.tv_jawaban_validasi.getText().toString().trim(), Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
//                }
////
////                if (holder.rb_optb.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
////                            Toast.makeText(context, "Jawaban Anda Benar" + holder.tv_jawaban_validasi.getText().toString().trim(), Toast.LENGTH_SHORT).show();
////                }
////                else {
////                    Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                }
////                if (holder.rb_optc.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
////                            Toast.makeText(context, "Jawaban Anda Benar" + holder.tv_jawaban_validasi.getText().toString().trim(), Toast.LENGTH_SHORT).show();
////                }
////                else {
////                    Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                }
////                if (holder.rb_optd.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
////                            Toast.makeText(context, "Jawaban Anda Benar" + holder.tv_jawaban_validasi.getText().toString().trim(), Toast.LENGTH_SHORT).show();
////                }
////                else {
////                    Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                }
////                if (holder.rb_opte.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
////                            Toast.makeText(context, "Jawaban Anda Benar" + holder.tv_jawaban_validasi.getText().toString().trim(), Toast.LENGTH_SHORT).show();
////                }
////                else {
////                    Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                }
//
//            }
//        });



//        holder.rg_rbjawaban.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean checked = ((RadioButton) view).isChecked();
//                switch (view.getId()){
//                    case R.id.rb_opta :
//                        if (checked){
////                            validasi();
//                            if (holder.rb_opta.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                                Toast.makeText(context, "Anda benar", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                Toast.makeText(context, "Anda salah", Toast.LENGTH_SHORT).show();
//                            }
//
////                            if (holder.tv_jawaban_validasi.getText().toString().equalsIgnoreCase()){
////                                Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
////                            }
////                            else {
////                                Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                            }
//                            break;
//                        }
//                    case R.id.rb_optb :
//                        if (checked){
////                            validasi();
//                            if (holder.rb_optb.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                                Toast.makeText(context, "Anda benar", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                Toast.makeText(context, "Anda salah", Toast.LENGTH_SHORT).show();
//                            }
////                            if (holder.holder.tv_jawaban_validasi.getText().toString().trim() == jawaban){
////                                Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
////                            }
////                            else {
////                                Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                            }
//                            break;
//                        }
//
//                    case R.id.rb_optc :
//                        if (checked){
////                            validasi();
//                            if (holder.rb_optc.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                                Toast.makeText(context, "Anda benar", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                Toast.makeText(context, "Anda salah", Toast.LENGTH_SHORT).show();
//                            }
////                            if (holder.holder.tv_jawaban_validasi.getText().toString().trim() == jawaban){
////                                Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
////                            }
////                            else {
////                                Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                            }
//                            break;
//                        }
//
//                    case R.id.rb_optd :
//                        if (checked){
////                            validasi();
//                            if (holder.rb_optd.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                                Toast.makeText(context, "Anda benar", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                Toast.makeText(context, "Anda salah", Toast.LENGTH_SHORT).show();
//                            }
////                            if (holder.holder.tv_jawaban_validasi.getText().toString().trim() == jawaban){
////                                Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
////                            }
////                            else {
////                                Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                            }
//                            break;
//                        }
//
//                    case R.id.rb_opte :
//                        if (checked){
////                            validasi();
//                            if (holder.rb_opte.getText().toString().trim() == holder.tv_jawaban_validasi.getText().toString().trim()){
//                                Toast.makeText(context, "Anda benar", Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                Toast.makeText(context, "Anda salah", Toast.LENGTH_SHORT).show();
//                            }
////                            if (holder.holder.tv_jawaban_validasi.getText().toString().trim() == jawaban){
////                                Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show();
////                            }
////                            else {
////                                Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show();
////                            }
//                            break;
//                        }
//
//                }
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return listSoal.size();
    }


}
