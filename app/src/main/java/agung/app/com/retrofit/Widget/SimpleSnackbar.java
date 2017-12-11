package agung.app.com.retrofit.Widget;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by agung on 12/7/2017.
 */

public class SimpleSnackbar {
    public static void showSuccess(View view, String message) {
        Snackbar snackbar;
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"));
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    public static void showError(View view, String message) {
        final Snackbar snackbar;
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.parseColor("#F44336"));
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.setAction("OK", v -> snackbar.dismiss());
        snackbar.show();
    }

    public static void showError(View view, String message, Context context) {
        final Snackbar snackbar;
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.parseColor("#F44336"));
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        // textView.setTextSize(context.getResources().getDimension(R.dimen.text_small));

        snackbar.setAction("OK", v -> snackbar.dismiss());
        snackbar.show();
    }

    public static void showInfo(View view, String message) {
        final Snackbar snackbar;
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.parseColor("#1976D2"));
        snackbar.setAction("OK", v -> snackbar.dismiss());

        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    public static void showInfoCallback(View view, String message, final InfoCallback infoCallback) {
        final Snackbar snackbar;
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.parseColor("#1976D2"));
        snackbar.setAction("OK", v -> {
            snackbar.dismiss();
            infoCallback.onClickListener();
        });

        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    public static void okSnackbar(View view, String message) {
        final Snackbar snackBar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        snackBar.setAction("OK", v -> snackBar.dismiss());
        snackBar.show();
    }

    public interface InfoCallback {
        void onClickListener();
    }
}
