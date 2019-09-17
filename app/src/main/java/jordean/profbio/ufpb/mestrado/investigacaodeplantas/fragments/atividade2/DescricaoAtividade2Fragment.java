package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade2;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.adapter.PlantasAdapter;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.ChaveIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescricaoAtividade2Fragment extends Fragment {

    private int imagensSpinner[] = {R.drawable.angiosperma_1_s, R.drawable.pteridofita_2_s, R.drawable.briofita_1_s,
            R.drawable.gimnosperma_2_s, R.drawable.angiosperma_2_s, R.drawable.pteridofita_1_s, R.drawable.briofita_2_s,
            R.drawable.gimnosperma_1_s};

    private int imagensMaiores[] = {R.drawable.angiosperma_1, R.drawable.pteridofita_2, R.drawable.briofita_1,
            R.drawable.gimnosperma_2, R.drawable.angiosperma_2, R.drawable.pteridofita_1, R.drawable.briofita_2,
            R.drawable.gimnosperma_1};

    private Button botaoIniciar;


    public DescricaoAtividade2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ChaveIdentificacaoModel chaveIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(ChaveIdentificacaoModel.class);
        chaveIdentificacaoModel.setPlantaEscolhida(imagensMaiores[0]);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = view.findViewById(R.id.spinner);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chaveIdentificacaoModel.setPlantaEscolhida(imagensMaiores[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        PlantasAdapter insetosAdapter = new PlantasAdapter(requireContext(), imagensSpinner);
        spin.setAdapter(insetosAdapter);


        botaoIniciar = view.findViewById(R.id.botao_iniciar_atividade2);

        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            botaoIniciar.setText("Solicitar Permissão de armazenamento");
        } else {
            botaoIniciar.setText("Iniciar atividade");
        }

        botaoIniciar.setOnClickListener(v -> {
            if(ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            } else {
                Pergunta1Fragment pergunta1Fragment = new Pergunta1Fragment();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container1, pergunta1Fragment)
                        .addToBackStack("Descricao 2")
                        .commit();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descricao_atividade2, container, false);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 1) {
            if(ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                botaoIniciar.setText("Iniciar atividade");
            } else {
                Toast.makeText(requireContext(), "Você não permitiu que o app utilizasse o" +
                        " armazenamento externo", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
