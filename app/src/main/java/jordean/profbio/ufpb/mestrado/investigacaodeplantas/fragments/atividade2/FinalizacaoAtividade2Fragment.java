package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade2;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.BuildConfig;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.ChaveIdentificacaoModel;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.util.AppStrings;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinalizacaoAtividade2Fragment extends Fragment {


    private String currentPdfPath;
    private ChaveIdentificacaoModel chaveIdentificacaoModel;
    private boolean pdfGerado;

    public FinalizacaoAtividade2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        chaveIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(ChaveIdentificacaoModel.class);

        ImageView plantaEscolhida = view.findViewById(R.id.imagem_resposta);
        plantaEscolhida.setImageResource(chaveIdentificacaoModel.getPlantaEscolhida());

        Button compartilharResultado = view.findViewById(R.id.botao_compartilhar_atv2);
        Button sair = view.findViewById(R.id.botao_sair_atv2);

        TextView textoResposta = view.findViewById(R.id.resposta_atividade2);
        textoResposta.setText(chaveIdentificacaoModel.getResultado());

        compartilharResultado.setOnClickListener(v -> {
            if (!pdfGerado) {
                criarPDF();
                pdfGerado = true;
            }
            if (currentPdfPath != null) {
                compartilharResposta();
            }
        });

        sair.setOnClickListener(v -> {
            requireActivity().finish();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finalizacao_atividade2, container, false);
    }

    private void compartilharResposta() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_STREAM, getFile(currentPdfPath));
        startActivity(Intent.createChooser(intent,"Compartilhar usando..."));
    }

    private void criarPDF() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;
        // create a new document
        PdfDocument document = new PdfDocument();

        int offset = 50;

        // crate a page description
        PdfDocument.PageInfo pageInfo =
                new PdfDocument.PageInfo.Builder(width, height, 1).create();

        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        float tamanhoFonte = getResources().getDimension(R.dimen.pdf_text_size);

        paint.setTextSize(tamanhoFonte);

        int larguraImagem = getResources().getDimensionPixelSize(R.dimen.atv2_img_w);
        int alturaImagem = getResources().getDimensionPixelSize(R.dimen.atv2_img_h);

        Bitmap imagem = BitmapFactory.decodeResource(requireContext().getResources(),
                chaveIdentificacaoModel.getPlantaEscolhida());
        imagem = Bitmap.createScaledBitmap(imagem, larguraImagem, alturaImagem, true);

        canvas.drawText("Planta Escolhida:", 50, offset, paint);
        offset += (int) (tamanhoFonte * 2.0);

        canvas.drawBitmap(imagem, 50, offset, paint);
        offset += alturaImagem + (int) (tamanhoFonte * 2.5);

        canvas.drawText(chaveIdentificacaoModel.getRespostaPergunta1(), 50, offset, paint);
        offset += (int) (tamanhoFonte * 2.5);
        if (chaveIdentificacaoModel.getRespostaPergunta2() != null) {
            canvas.drawText(chaveIdentificacaoModel.getRespostaPergunta2(), 50, offset, paint);
            offset += (int) (tamanhoFonte * 2.5);
        }
        if (chaveIdentificacaoModel.getRespostaPergunta3() != null) {
            canvas.drawText(chaveIdentificacaoModel.getRespostaPergunta3(), 50, offset, paint);
            offset += (int) (tamanhoFonte * 2.5);
        }
        if (chaveIdentificacaoModel.getRespostaPergunta4() != null) {
            canvas.drawText(chaveIdentificacaoModel.getRespostaPergunta4(), 50, offset, paint);
            offset += (int) (tamanhoFonte * 2.5);
        }
        if (chaveIdentificacaoModel.getRespostaPergunta5() != null) {
            canvas.drawText(chaveIdentificacaoModel.getRespostaPergunta5(), 50, offset, paint);
            offset += (int) (tamanhoFonte * 2.5);
        }
        canvas.drawText(chaveIdentificacaoModel.getResultado(), 50, offset, paint);

        document.finishPage(page);

        File diretorioDoApp = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + AppStrings.NOME_DIRETORIO_APP);
        if (!diretorioDoApp.exists()) {
            diretorioDoApp.mkdir();
        }

        File filePath = new File(diretorioDoApp + File.separator + "ATV_" + System.currentTimeMillis() + ".pdf");
        try {
            document.writeTo(new FileOutputStream(filePath));
            currentPdfPath = filePath.getPath();
            Toast.makeText(requireActivity(), "Atividade salva em " + currentPdfPath, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(requireActivity(), "Erro: " + e.toString(),
                    Toast.LENGTH_LONG).show();
        }

        // close the document
        document.close();
    }

    private Uri getFile(String path) {
        File file = new File(path);
        return FileProvider.getUriForFile(requireContext(), BuildConfig.APPLICATION_ID.concat(".provider"), file);
    }

}
