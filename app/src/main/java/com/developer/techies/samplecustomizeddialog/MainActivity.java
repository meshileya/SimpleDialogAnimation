package com.developer.techies.samplecustomizeddialog;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog(View view) {
        final Dialog dialog = new Dialog(this,
                R.style.PauseDialog);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);

        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        dialog.setTitle(null);
        dialog.setContentView(R.layout.dialog_sample);
        dialog.setCancelable(true);

        dialog.show();

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        };

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 5000);
    }
}
