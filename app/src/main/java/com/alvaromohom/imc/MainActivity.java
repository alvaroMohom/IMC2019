package com.alvaromohom.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class MainActivity extends AppCompatActivity {

        private EditText mCampoPeso, mCampoEstatura;
        private Button mBotonCalcular, mBotonLimpiar;
        private TextView mEtiquetaImc, mInformacionNutricional;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mCampoPeso = (EditText) findViewById(R.id.campo_peso);
            mCampoEstatura = (EditText) findViewById(R.id.campo_estatura);
            mBotonCalcular = (Button) findViewById(R.id.boton_calcular);
            mBotonLimpiar = (Button) findViewById(R.id.boton_limpiar);
            mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);
            mInformacionNutricional = (TextView) findViewById(R.id.etiqueta_información);

            mBotonCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = mCampoPeso.getText().toString();
                    double peso = Double.parseDouble(s);
                    s = mCampoEstatura.getText().toString();
                    double estatura = Double.parseDouble(s);
                    double imc = peso / (estatura * estatura);
                    s = String.format("%2.2f", imc);
                    mEtiquetaImc.setText(s);

                    if (imc < 18.5) {
                        mInformacionNutricional.setText("Peso bajo");
                    }
                    else if (imc < 25.0){
                        mInformacionNutricional.setText("Peso normal");
                    }
                    else if (imc < 30.0) {
                        mInformacionNutricional.setText("Sobrepeso");
                    }
                    else if (imc < 40.0) {
                        mInformacionNutricional.setText("Obesidad");
                    }
                    else if (imc> 40.0){
                        mInformacionNutricional.setText("Obesidad Extrema");
                    }
                }

            });

            mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCampoPeso.setText("");
                    mCampoEstatura.setText("");
                    mEtiquetaImc.setText("0.0");
                    mInformacionNutricional.setText("");
                }
            });

        }
    }
}
