package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoritesMovie() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoritesMovie(1, 2L);
		favoritesDao.addFavoritesMovie(1, 5L);
		favoritesDao.addFavoritesMovie(2, 1L);
		favoritesDao.addFavoritesMovie(2, 3L);
		Favorites moviesListCustomer = favoritesDao.getAllFavoritesMovies(1);
		System.out.println("User Added Favorites list for Checkout");
		for (Movies movies : moviesListCustomer.getMoviesList()) {
			System.out.println(movies);
		}
		System.out.println("No Of Favorites:" + moviesListCustomer.getMoviesList());
	}

	public static void testRemoveFavoritesMovie() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Movies List for Customer after Remove");
		try {
			favoritesDao.removeFavoritesMovie(1, 5L);
			favoritesDao.removeFavoritesMovie(1, 3L);
			Favorites moviesListCustomer = favoritesDao.getAllFavoritesMovies(1);
			for (Movies movies : moviesListCustomer.getMoviesList()) {
				System.out.println(movies);
			}
			System.out.println("No Of Favorites:" + moviesListCustomer.getMoviesList());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoritesMovie() {
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoritesMovie();
		testRemoveFavoritesMovie();
	}

}
