package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.angiospermas;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.TelaFotoFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.util.AppStrings;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaAngiospermasAFragment extends TelaFotoFragment {


    private ImageView imageAngiospermas;
    private FotoIdentificacaoModel fotoIdentificacaoModel;

    public EtapaAngiospermasAFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setFotoAngiospermas(null);

        imageAngiospermas = view.findViewById(R.id.image_angiospermas);

        imageAngiospermas.setOnClickListener(v -> openCamera(CAMERA_ACTION_PICK_REQUEST_CODE_1));

        Button proxima = view.findViewById(R.id.button_next6a);

        proxima.setOnClickListener(v -> {
            EtapaAngiospermasA1Fragment etapaAngiospermasA1Fragment = new EtapaAngiospermasA1Fragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaAngiospermasA1Fragment)
                    .addToBackStack("Questao 6a")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_angiospermas_a, container, false);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CAMERA_ACTION_PICK_REQUEST_CODE_1 && resultCode == RESULT_OK && data != null) {
            String imagePath = data.getStringExtra("file_name");
            fotoIdentificacaoModel.setFotoAngiospermas(imagePath);
            loadImage(imagePath, imageAngiospermas);
        } else if(resultCode == 1 || resultCode == 2){
            Toast.makeText(requireContext(), AppStrings.ERRO_TIRAR_FOTO, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(requireContext(), AppStrings.FOTO_NAO_TIRADA, Toast.LENGTH_LONG).show();
        }
    }

}
