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
import com.example.atletas.controller.OperacaoJuvenil;
import com.example.atletas.controller.OperacaoSenior;
import com.example.atletas.model.Juvenil;
import com.example.atletas.model.Senior;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtletaJuvenilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtletaJuvenilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private EditText txtNome, txtData, txtBairro, txtAnos;
    private Button btnCadastrar;
    TextView txtResultado;

    public AtletaJuvenilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AtletaJuvenilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AtletaJuvenilFragment newInstance(String param1, String param2) {
        AtletaJuvenilFragment fragment = new AtletaJuvenilFragment();
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
        view = inflater.inflate(R.layout.fragment_atleta_juvenil, container, false);

        txtNome = view.findViewById(R.id.txtNome);
        txtData = view.findViewById(R.id.txtDataNascimento);
        txtBairro = view.findViewById(R.id.txtBairro);
        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        txtAnos = view.findViewById(R.id.txtAnosPratica);
        txtResultado = view.findViewById(R.id.txtResultado);
        btnCadastrar.setOnClickListener(op -> cadastrar());
        return view;
    }

    private void cadastrar() {
        Juvenil j = new Juvenil();
        j.setNome(txtNome.getText().toString());
        j.setBairro(txtBairro.getText().toString());
        String data = txtData.getText().toString();
        Date date = convertStringToDate(data);
        j.setAnosPratica(Integer.parseInt(txtAnos.getText().toString()));
        j.setNascimento(date);

        IOperacao op = new OperacaoJuvenil();
        op.cadastrar(j);
        List<Juvenil> lista = op.listar();
        StringBuffer buffer = new StringBuffer();
        for(Juvenil ju: lista){
            buffer.append(ju.toString() + "\n");
        }

        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
        txtResultado.setText(buffer.toString()) ;
        limpaCampos();
    }

    private void limpaCampos() {
        txtNome.setText("");
        txtBairro.setText("");
        txtData.setText("");
        txtAnos.setText("");
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