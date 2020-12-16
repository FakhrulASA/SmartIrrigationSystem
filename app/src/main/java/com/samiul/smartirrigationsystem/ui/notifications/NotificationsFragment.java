package com.samiul.smartirrigationsystem.ui.notifications;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.samiul.smartirrigationsystem.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    ImageView call,fb,mail;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        call=root.findViewById(R.id.imagecall);
        fb=root.findViewById(R.id.imagefb);
        mail=root.findViewById(R.id.imagemail);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "01851570827", null));
                startActivity(intent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/samiul827"));
                startActivity(browserIntent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "mdsamiulislam28@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Help for Smart Irrigation System");
                    startActivity(emailIntent);

            }
        });
        return root;
    }
}