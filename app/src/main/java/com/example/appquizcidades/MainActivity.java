package com.example.appquizcidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String CIDADES[][] = {
            { "BARCELONA",      "https://uce58d6fbcf9036f30bc85846fe9.previews.dropboxusercontent.com/p/thumb/ABo-8j0eVZWP3naXbQW4IvVJPs46NgKSU7X-O-QCZOwCEjwz4tu0IxjqDRvJ4ng1QreZ-qU2aYNyj_ljtgdEe7ExN61tSRQzxwfZrr53B1EWmO7dzKijW1yDQPTtZwIKbNsm0Dll8KwqZKRfIWm2l8tNoYPSryTr0m4tvaZpivtpkF2s85nyZiLSwsBGz6xmhGSfsJB65n9PD0pPfYU7Ef6CvHSiATzMnkCbN6UyckVqPqU9RmwKo-GJExq5Rp4kJLQqGjiB36RbVvvOHXEaniH0q8sCKou7vKUdpycTGSZHcNF_iunhRdHo-he1AqzQNLMFykS3mMMjOGDLI5RKJKXWsLStKrp7VxZj1X8Q5Ax2jN2hmD5Pgaqezy9L4DxqmVszqHrtW_ccfCkw6Zer6_KasF4jb4BW9pEq6EuQkwDrEg/p.jpeg"},
            { "BRASILIA",       "https://ucce1771f9689d071d21f115aa88.previews.dropboxusercontent.com/p/thumb/ABqjmQjYI82_At4Txwev3QNvbdvgwXXHSTsOohLUDrvVKCXq5S99q7q1v92FQOla9Jl7h4LNhz_0FurQAd0tCuF-gyYvpcnyt7zznHI_WebOdMRnkL_IonrB8RbRmA0Mm3EoA2YKEL9-DzyTR9suLqGnd5aPYWVLmHeruNkaNBjlIJhBNpW5EH9M1Tr7gaETWP7VjBPNfc1vkZpe8U4ZlY84BX1MxHzGllIi3uLiUxigJr8jcrmGOXte2HG-yu7SqLFUkeMNu-2qyFLyO2tcxP9XDR743ZFQemb4Egu5m3q5loniM014dMkPvSshTzko3Nl-qwvsN-14Gf1CHrIHQxyIMUU71mgdXTnaljGLPOTfkBfn7qxWMMv4itgARYTRRrKK_alg3ZiVdzFyMMOmM1Wlc2YoeBYiVeQXLpV5mHmCFA/p.jpeg"},
            { "CURITIBA",       "https://uc9b50677e9b424c738eee33d367.previews.dropboxusercontent.com/p/thumb/ABp5Rc7fMPT845eyqd0-VYzUNlcJFN0KU1Pw6L3L3_pImLqayb6CLSLOas9wyZWertlUMVEbsUhYvDyGjtGAag29JJMQZapCJmXgUl0oPYeXFnevR_eFwHOMEb589S005GeTSIpCIW2_gMlRsmlPj4m0ERmCN8DZO66U6XaOcWPLA9tZDTDgUEpatVMYbb-LZ3Q9mG5LsuJSe5mhXntYZyMSQ6v4468qaUAnrVfFwGSxMY-x8jJaA1taqwNQk67KHxzalBXwkM-Le1zTTcWIweAOWMs6Fqr9nNTm3RNF4xuRtJh2iimgv3Yh1pjqKhJKyiE7Jh1fYGh3OX8dKtK7xTpH_HW_Gws0VEgd4aJKIvXvhmyYw6kHcqc8E1AMA_dnJDULo_AuJMQIn0JI95BA8xNzj2SaGKkINCk3Lb-RSCTAtQ/p.jpeg"},
            { "LAS VEGAS",      "https://uca4fac2e442e066e9d332a9bc06.previews.dropboxusercontent.com/p/thumb/ABqY8U5SCboovyL4tZZMMVKIkHODszgKcKBfoYR-grLeq-EFOfff__SQvoBI3vCxKUvZUKBVpazHiH_vKrLba_EzsG9sn61tYnNW4zvoTuUAmz0r5eUTzJc85oAvv0JWfKJDMPPz2VBYEx3uHtP9xincLidEfnk3Ste7BKjWEI0f07LbY8zHm48D-gG5zyBuEvsQ7B8oq24PF-NmOpW29onrddi_u-3fZ3E9IWASdSqvTQqKBSZhvp86a9YaREfuzGml9wfZcNHsTjhyJ595-qHTiY0QpwbDQbrrmv8vkCopTFcPI-b9ZnrE6WHiRzURmUv3paXGCIDojmGT4SSkvKU8WU-GNLU_45ykWFoBRS-q8A-DFx_IIySCSLW2hTHlT1JKw-Y0mFnLHDpoWwqKZ2-RRvCU_ypgbBPaZFmGUZBRGg/p.jpeg"},
            { "MONTREAL",       "https://uce02d491830a0502fbd4bf9a582.previews.dropboxusercontent.com/p/thumb/ABqveARl1Qlo0YRR6-Cp7kgwedEiyXIByG8uhKDblx75uMy4NfBwpMOFPtsaTOb-QgkgM9AS8hpZWWDPEGexmofG0x2x0u_UQ9hjHmBFd9i4uJ23OlsI_YHIrwVYhi99F9gGZahTX78kS4k4pWQM5HLJMBMVmeI1Ie_nSYw7grW0vbtNLIniFPIZU1838CW3Hq8JzqSvtnpI8Jn6CC1RgNWToEGPgZ_5Ggf6fXCvWgCzP1wECO9yUjNk1Db7xh2ZCxm7tsnghmpxrUj2dhteZsufhTPhaZG0IfNHcPypxqoqj730Cq41ymYcB75eQ79cpzIMdoz_HvEeNXfaczF-zzVjcLC4kN6dR6CKrpOo8_GP9oSn17bhDCcY2ft9h7P795r7X3pHKOSZfsWQNHI86SN1p_kMtyp5kAsyMTfJ1bxcZw/p.jpeg"},
            { "PARIS",          "https://uc91c1aa6275273ca78e95ff3939.previews.dropboxusercontent.com/p/thumb/ABqEvibhs__pd2ugeHKQZ9oHokqqeeEXkRtd90M600P2QiArhwL_4LblfmmmaT1iQoPoloOvDb2ChbmRz8_fgnE6r0VhF6mCGIGSprCFX1ny0MZpPqy52pUTHIFBUXVyPWmECq59lRC-uljswpwWEyNoOvIVQ5iht7PWzjM-T5L_8D2CYqJWo4v9ovO16iPVqd1SGOGvrM929lgHObiS7HDaEgwnsbyHRNTkfNCVDSy-6hzfVyPITOh3b8fLqB4J7Yi7AZZVvbmUnKetLTrVDn_u_JWDl_YvuCwe5c83m9aTZCIF4QBwwyr8lSOJGBVW2dFCFBRXTdd_Yx67oVBoXLMI503dbGucwVucuA-UWZ-lh3XQKSH3d2I78P0nG69RnohR8IJhLZdD2FGM_OL_bF2nzkRfj6LTym1UmhVw1W2eUg/p.jpeg"},
            { "RIO DE JANEIRO", "https://uc52498915a38081f9680290b262.previews.dropboxusercontent.com/p/thumb/ABp5QNMWXM1ZjZfDLm0y3rfJTW-CeHcvozIqB3fFmWy1VY43YbhZaLbkk-QTqIiMOMUdA9jrhocBjqAJsZ24ZZRR0aEF-LfYm5VFYpUwW7tPuspCHArmzYEknlBIO123hVivya3E0nRgjFfLnNp-u-CBD7enB6YKOxUoMyiSSDCb3h2G3U1sQuwncsxWAtqeWsOE3aXr3o3v3uMXaf_YTmJkX8a_Dd4dfb2z_F-OHF39qIEZWUPH5SxRH95ihFKg55x3ovNrVrSNS7C6ycMULDi-IK4o99JXYfVZ2eT9C_9IJfTY8nUlZe6wv9Lx1XQNi15dWuR888fN6azfm5BgLvvaLmlnnQMgBzhlGKDq4B3uOjmLqb6XvrzK4L4l26yRFstiDXXDxAmrJN9o2eeOE-4PA7hcZkrLek3ukANJRmamrw/p.jpeg"},
            { "SALVADOR",       "https://uc77694ca850328f966a24b6adc3.previews.dropboxusercontent.com/p/thumb/ABoeNdT2zIpMkN746TGZ0sxK8kxIzmB9CpXfXwFK-OGDBeOcmJ2xXYnsLH_vnpNIt0i6bJF7mDfO-qYPTqYEn472uZYi4Z6LAxeeMNOvdF3mj-Ch1lLzl0TXrB3K1FQae_XYITFJjrnmxPT_bbMF1BMh8N7na8j0Oj9HBwR27hRS6Qe__shc_KAuLj9zF3wWfUGstX06U2rv8Cb9XHVtQsHMDpBhauBuo2uTCV-HvwaiiNJMitwh0rWyFN1zdDwAOGJnLRJP8SmVrZFDwqN_UTr_S-9NILNJx1xJ4_cVsQyuJrVl8G34O69qmsYFXlH_E4dX8gycRg1Xaee4wbXylynFjnobYs2JFqQrMMLNjU7-_-qmyB4F7h3hz5F48sJSboog8vSwogrcDhpH7nfjAiztj_mdAEkwfbKLQ7k7r8ul-w/p.jpeg"},
            { "SAO PAULO",      "https://ucc3e47710c4b94ca001771d634d.previews.dropboxusercontent.com/p/thumb/ABpboJ1thmFmqVDn5VCNrUrgvNOe-V5AMCiNvDESde6qfBQ8whf7kq4uGwXu04XmjiI3TroDgYSUgQshY2aWlKZvqh3q5nMKt4vOOUAFBCDU3Zi6Ahl4_9YUFeLs03sOVla0xwXEZj48KtHtpjtBUMafsb_wwFxitQEbpiQo1Uk-7zVKhYNkb52A1SJrcan5kCkGAWdzYhP2kszAWPb47ePe-JzA1Wb4s59vE00OpAaR8RdJuuq7Ft7wK7Mouj1lYdt_x9F5sDrAUA30l79fL_4sypEPDh76tBPsNzP5z_x_5YMNHDq-d4uMONdJgkBbCQSXiLkwrwjK08htnMPGPrQPk-fsweLCunKbE5ODzTqyk0yfsVnb3wH-0TLImw7psWhdkAvTpocVn-dD5atXQaGPjAcSE2foLBWjorykuF1P5w/p.jpeg"},
            { "TOQUIO",         "https://uc123a32bb75be27dca6c40c28e6.previews.dropboxusercontent.com/p/thumb/ABq_op85Os8d9NoLIXtzZVy_vHih32oVINDigZjEma5LTrNDcyD8fhxWbHljJTkE8T9ulDkMfzxjpYpQFPIZ4KblQaDE58MXINbD9CNCMg4iHFr0qmuVS3rE32aW64JKZJ3ujvXpBfporcd9vSOB9yy9r4VHDjmUOGuQAb3pELoCj7W0lSkhPWEKPjM7rnemtb91JliSEJzGnk2rFYjFcoYdft7TKU3DwCwud0fdiDJr0AzkHlKX_fpYU5doeJ8FxXxG_6fyTCGQvE3IR1TysVkuLovyyKVitPN_VAoNiF3GOiB7rON8owShhseoHsDdqAso7rE0Qx90A8-4eMXjeFobnsfZWy04hlmnDmBGQHB3aczRhABjThYn089QQrn0goFeO5hIKClNLnbi-5tXg86dqySwty4iJtGiCxDc54k5cg/p.jpeg"}
    };

    private final int NOME = 0;
    private final int URL  = 1;

    private int random;
    private int pontos = 0;
    private int rodada = 1;

    ImageView imageView;
    EditText editTextInput;
    TextView textViewOutput;
    Button buttonResponder;
    Button buttonProxima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView       = findViewById(R.id.imageView);
        editTextInput   = findViewById(R.id.editTextResposta);
        textViewOutput  = findViewById(R.id.textViewResultado);
        buttonResponder = findViewById(R.id.buttonResponder);
        buttonProxima   = findViewById(R.id.buttonProxima);

        preparaRodada();
    }

    public void preparaRodada() {

        Random r = new Random();

        random = r.nextInt(10);

        new DownloadImageTask(imageView).execute(CIDADES[random][URL]);

        editTextInput.setText("");
        textViewOutput.setText("");
        buttonResponder.setEnabled(true);
        buttonProxima.setEnabled(false);

    }


    public void responder(View view) {

        String str = editTextInput.getText().toString();

        if (str.isEmpty())
            Toast.makeText(this, "Qual a cidade?", Toast.LENGTH_SHORT).show();
        else {
            if (str.equalsIgnoreCase(CIDADES[random][NOME])) {
                textViewOutput.setText("Acertou!!!");
                pontos += 25;
            } else {
                textViewOutput.setText("Errou!!! Era " + CIDADES[random][NOME]);
            }

            buttonResponder.setEnabled(false);

            if (rodada == 4) {
                Intent it = new Intent(this, Pontuacao.class);
                it.putExtra("pontos", pontos);
                startActivity(it);
            } else {
                rodada++;
                buttonProxima.setEnabled(true);
            }


        }

    }

    public void proxima(View view) {
        preparaRodada();
    }

}