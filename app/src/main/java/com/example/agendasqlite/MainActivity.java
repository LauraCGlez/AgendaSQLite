package com.example.agendasqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edNombre, edTelefono;
    AdminSQLiteOpenHelper adminSQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activitymain);
        edNombre.findViewById(R.id.edNombre);
        edTelefono.findViewById(R.id.edTelefono);
        adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "bd1", null, 1);
    }

    public void agregar(View view) {
        SQLiteDatabase db = adminSQLiteOpenHelper.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nombre", edNombre.getText().toString());
        registro.put("telefono", edTelefono.getText().toString());
        db.insert("agenda", null, registro);
        edNombre.setText("");
        edTelefono.setText("");
        db.close();
    }

}
