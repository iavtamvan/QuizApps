package com.sandec.iavariav.root.quizapps.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sandec.iavariav.root.quizapps.Model.SoalModel;
import com.sandec.iavariav.root.quizapps.R;
import com.sandec.iavariav.root.quizapps.rest.ApiService;
import com.sandec.iavariav.root.quizapps.rest.Client;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 2/3/18.
 */

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.ViewHolder> {
    //    deklarasi variabel variabel
    Context context;
    List<SoalModel> listSoal;

    public SoalAdapter(Context context, ArrayList<SoalModel> listSoal) {
        this.context = context;
        this.listSoal = listSoal;
    }

    @Override
    public SoalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal, parent, false);
        return new ViewHolder(view);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivGambarSoal;
        private TextView tvPertanyaan, tvJawabanValidasi;
        private RadioGroup rgGroupJawaban;
        private RadioButton rbOpta, rbOptb, rbOptc, rbOptd, rbOpte;
        private String idSoal;

        private AlertDialog.Builder builder;
        private LayoutInflater inflater;

        private Button btnUpdate;
        private Button btnBatal;
        private EditText edtImage;
        private EditText edtJawaban;
        private EditText edtOpte;
        private EditText edtOptd;
        private EditText edtOptc;
        private EditText edtOptb;
        private EditText edtOpta;
        private EditText edtPertanyaan;

        public ViewHolder(View itemView) {
            super(itemView);
            ivGambarSoal = itemView.findViewById(R.id.iv_gambarSoal);
            tvPertanyaan = itemView.findViewById(R.id.tv_pertanyaan);
            rgGroupJawaban = itemView.findViewById(R.id.rg_rbjawaban);
            tvJawabanValidasi = itemView.findViewById(R.id.tv_jawaban_validasi);
            rbOpta = itemView.findViewById(R.id.rb_opta);
            rbOptb = itemView.findViewById(R.id.rb_optb);
            rbOptc = itemView.findViewById(R.id.rb_optc);
            rbOptd = itemView.findViewById(R.id.rb_optd);
            rbOpte = itemView.findViewById(R.id.rb_opte);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    idSoal = listSoal.get(position).getID();
                    Toast.makeText(context, "" + idSoal, Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "" + idSoal, Toast.LENGTH_SHORT).show();
                    builder = new AlertDialog.Builder(context);
                    inflater = LayoutInflater.from(context);
                    final View dialView = inflater.inflate(R.layout.dialog_pilih_aksi, null);

                    final Button btnDialogUpdate = (Button) dialView.findViewById(R.id.btn_dialog_update);
                    final Button btnDialogDelete = (Button) dialView.findViewById(R.id.btn_dialog_delete);

                    btnDialogUpdate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            final View dialView = inflater.inflate(R.layout.dialog_update, null);
                            edtPertanyaan = (EditText) dialView.findViewById(R.id.edt_pertanyaan);
                            edtOpta = (EditText) dialView.findViewById(R.id.edt_opta);
                            edtOptb = (EditText) dialView.findViewById(R.id.edt_optb);
                            edtOptc = (EditText) dialView.findViewById(R.id.edt_optc);
                            edtOptd = (EditText) dialView.findViewById(R.id.edt_optd);
                            edtOpte = (EditText) dialView.findViewById(R.id.edt_opte);
                            edtJawaban = (EditText) dialView.findViewById(R.id.edt_jawaban);
                            edtImage = (EditText) dialView.findViewById(R.id.edt_image);
                            btnBatal = (Button) dialView.findViewById(R.id.btn_batal);
                            btnUpdate = (Button) dialView.findViewById(R.id.btn_update);

                            btnUpdate.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    ApiService apiService = Client.getInstanceRetrofit();
                                    apiService.updateData(
                                            idSoal,
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
                                                    Toast.makeText(context, "" + error_msg, Toast.LENGTH_SHORT).show();
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        @Override
                                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                                            Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                        }
                    });

                    btnDialogDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ApiService apiService = Client.getInstanceRetrofit();
                            apiService.deleteData(idSoal)
                                    .enqueue(new Callback<ResponseBody>() {
                                        @Override
                                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                            if (response.isSuccessful()){
                                                try {
                                                    JSONObject jsonObject = new JSONObject(response.body().string());
                                                    String error_msg = jsonObject.optString("error_msg");
                                                    Toast.makeText(context, "" + error_msg, Toast.LENGTH_SHORT).show();
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                                            Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    });
                    builder.setView(dialView);
                    builder.show();

                }
            });

        }
    }

    @Override
    public void onBindViewHolder(final SoalAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(listSoal.get(position).getIMG())
                .thumbnail(1f)
                .error(R.drawable.sandec)
                .into(holder.ivGambarSoal);
        holder.tvPertanyaan.setText(listSoal.get(position).getPERTANYAAN());
        holder.rbOpta.setText(listSoal.get(position).getOPTA());
        holder.rbOptb.setText(listSoal.get(position).getOPTB());
        holder.rbOptc.setText(listSoal.get(position).getOPTC());
        holder.rbOptd.setText(listSoal.get(position).getOPTD());
        holder.rbOpte.setText(listSoal.get(position).getOPTE());
        holder.tvJawabanValidasi.setText(listSoal.get(position).getJAWABAN());
        holder.rgGroupJawaban.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String selectedRadioButtonText;
                int selectedRadioButtonID = holder.rgGroupJawaban.getCheckedRadioButtonId();

                if (selectedRadioButtonID != 1) {
                    RadioButton selectedRadioButton = radioGroup.findViewById(selectedRadioButtonID);
                    selectedRadioButtonText = selectedRadioButton.getText().toString().trim();
                    Toast.makeText(context, "" + selectedRadioButtonText, Toast.LENGTH_SHORT).show();

                    if (selectedRadioButtonText.equalsIgnoreCase(holder.tvJawabanValidasi.getText().toString().trim())) {
                        Toast.makeText(context, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Pilih  jawaban", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSoal.size();
    }


}
