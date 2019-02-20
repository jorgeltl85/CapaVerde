package com.sl2.capaverde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    long movieNum = 0, actorNum = 0;
    DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daoSession = ((MiAplicacion)getApplication()).getDaoSession();
    }

    public void createMovie(View v) {
        // create Movie object
        movieNum += 1;
        Pelicula movie1 = new Pelicula(null, "Movie" + String.valueOf(movieNum));
        long movieID = daoSession.getPeliculaDao().insert(movie1);

        // create Actor objects
        List<Actor> actors = new ArrayList<>(2);
        actorNum += 1;
        Actor actor1 = new Actor(null, "Name " + String.valueOf(actorNum),
                "LastName " + String.valueOf(actorNum), 24, movieID);
        actors.add(actor1);

        actorNum += 1;
        Actor actor2 = new Actor(null, "Name " + String.valueOf(actorNum),
                "LastName " + String.valueOf(actorNum), 24, movieID);
        actors.add(actor2);

        // add actors to movie
        daoSession.getActorDao().insertInTx(actors);
    }

    public void listMovies(View v) {
        List<Pelicula> movies = daoSession.getPeliculaDao().loadAll();
        List<String> actorsList = new ArrayList<>();

        for (Pelicula m : movies) {
            for (Actor a : m.getActorList()) {
                actorsList.add(a.getNombre() + " " + a.getApellido());
            }
            String actors = TextUtils.join(", ", actorsList);
            actorsList.clear();
            Log.d("TAG", String.format("%s (%s)", m.getTitulo(), actors));
        }
    }

    public void deleteMovies(View v) {
        daoSession.getPeliculaDao().deleteAll();
        daoSession.getActorDao().deleteAll();
    }

    public void activarTodo(View v){
        Toast.makeText(this, "Ingresando", Toast.LENGTH_SHORT).show();
    }
}
