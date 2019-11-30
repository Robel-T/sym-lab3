/**
 * Fichier: ScanActivity.java
 *
 * Auteur: Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date  : 1 Décembre 2019
 *
 * But   : Implémentation de l'activité qui lance la camera pour lire le QRcode
 *
 */

package com.example.lab3_sym.Activity.QR;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class ScanActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(me.dm7.barcodescanner.zbar.Result result) {
        QrActivity.response.setText(result.getContents());
        onBackPressed();
    }
}