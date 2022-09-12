package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.COMEDY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Farrelly brothers"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "J. J. Abrams"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Wes Craven"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Chris Columbus"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "The Wachowskis")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        assertThat(movies.stream().map(Movie::getId).collect(Collectors.toList()), is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(movies.stream().map(Movie::getId).collect(Collectors.toList()), is(Arrays.asList(2, 3, 4, 5, 6)));

    }

    @Test
    public void return_movies_by_director() {

        Collection<Movie> movies = movieService.findMoviesByDirector("Christopher Nolan");
        assertThat(movies.stream().map(Movie::getId).collect(Collectors.toList()), is(Arrays.asList(1, 2)));
    }
}