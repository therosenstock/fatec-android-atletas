package com.example.atletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.atletas.controller.IOperacao;
import com.example.atletas.controller.OperacaoSenior;
import com.example.atletas.model.Senior;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtletaSeniorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtletaSeniorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View view;
    private EditText txtNome, txtData, txtBairro;
    private CheckBox checkCardiaco;
    private Button btnCadastrar;
    TextView txtResultado;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AtletaSeniorFragment() {
        // Required empty public constructor
    }

    public static AtletaSeniorFragment newInstance(String param1, String param2) {
        AtletaSeniorFragment fragment = new AtletaSeniorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_senior, container, false);

        txtNome = view.findViewById(R.id.txtNome);
        txtData = view.findViewById(R.id.txtDataNascimento);
        txtBairro = view.findViewById(R.id.txtBairro);
        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        checkCardiaco = view.findViewById(R.id.checkCardiaco);
        txtResultado = view.findViewById(R.id.txtResultado);
        btnCadastrar.setOnClickListener(op -> cadastrar());
        return view;

    }

    private void cadastrar() {
        Senior s = new Senior();
        s.setNome(txtNome.getText().toString());
        s.setBairro(txtBairro.getText().toString());
        String data = txtData.getText().toString();
        Date date = convertStringToDate(data);
        s.setCardiaco(checkCardiaco.isChecked());
        s.setNascimento(date);

        IOperacao op = new OperacaoSenior();
        op.cadastrar(s);
        List<Senior> lista = op.listar();
        StringBuffer buffer = new StringBuffer();
        for(Senior se: lista){
            buffer.append(se.toString() + "\n");
        }
        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
        txtResultado.setText(buffer.toString()) ;
        limpaCampos();
    }

    private void limpaCampos() {
        txtNome.setText("");
        txtBairro.setText("");
        txtData.setText("");
        checkCardiaco.setChecked(false);
    }

    private Date convertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}