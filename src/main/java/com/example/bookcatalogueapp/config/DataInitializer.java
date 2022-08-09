package com.example.bookcatalogueapp.config;

import com.example.bookcatalogueapp.dto.request.AuthorRequestDto;
import com.example.bookcatalogueapp.dto.request.BookRequestDto;
import com.example.bookcatalogueapp.service.AuthorService;
import com.example.bookcatalogueapp.service.BookService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final BookService bookService;
    private final AuthorService authorService;

    public DataInitializer(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void inject() {
        AuthorRequestDto jamesJoyce = new AuthorRequestDto();
        jamesJoyce.setAuthorName("James Joyce");
        Long jamesJoyceId = authorService.createAuthor(jamesJoyce).getId();

        BookRequestDto ulysses = new BookRequestDto();
        ulysses.setBookName("Ulysses");
        ulysses.setPublishedAmount(1_000_000L);
        ulysses.setSoldAmount(990_000L);
        ulysses.setAuthorId(jamesJoyceId);
        bookService.createBook(ulysses);

        BookRequestDto dubliners = new BookRequestDto();
        dubliners.setBookName("Dubliners");
        dubliners.setPublishedAmount(500_000L);
        dubliners.setSoldAmount(300_000L);
        dubliners.setAuthorId(jamesJoyceId);
        bookService.createBook(dubliners);

        BookRequestDto finnegansWake = new BookRequestDto();
        finnegansWake.setBookName("Finnegans Wake");
        finnegansWake.setPublishedAmount(780_000L);
        finnegansWake.setSoldAmount(240_000L);
        finnegansWake.setAuthorId(jamesJoyceId);
        bookService.createBook(finnegansWake);

        AuthorRequestDto gabrielGarciaMarquez = new AuthorRequestDto();
        gabrielGarciaMarquez.setAuthorName("Gabriel Garcia Marquez");
        Long gabrielGarciaMarquezId = authorService.createAuthor(gabrielGarciaMarquez).getId();

        BookRequestDto inEvilHour = new BookRequestDto();
        inEvilHour.setBookName("Strange Pilgrims");
        inEvilHour.setPublishedAmount(280_000L);
        inEvilHour.setSoldAmount(120_000L);
        inEvilHour.setAuthorId(gabrielGarciaMarquezId);
        bookService.createBook(inEvilHour);

        BookRequestDto strangePilgrims = new BookRequestDto();
        strangePilgrims.setBookName("In Evil Hour");
        strangePilgrims.setPublishedAmount(410_000L);
        strangePilgrims.setSoldAmount(360_000L);
        strangePilgrims.setAuthorId(gabrielGarciaMarquezId);
        bookService.createBook(strangePilgrims);

        BookRequestDto leafStorm = new BookRequestDto();
        leafStorm.setBookName("Leaf Storm");
        leafStorm.setPublishedAmount(540_000L);
        leafStorm.setSoldAmount(370_000L);
        leafStorm.setAuthorId(gabrielGarciaMarquezId);
        bookService.createBook(leafStorm);

        AuthorRequestDto ernestHemingway = new AuthorRequestDto();
        ernestHemingway.setAuthorName("Ernest Hemingway");
        Long ernestHemingwayId = authorService.createAuthor(ernestHemingway).getId();

        BookRequestDto inOurTime = new BookRequestDto();
        inOurTime.setBookName("In Our Time");
        inOurTime.setPublishedAmount(657_000L);
        inOurTime.setSoldAmount(493_000L);
        inOurTime.setAuthorId(ernestHemingwayId);
        bookService.createBook(inOurTime);

        BookRequestDto theSunAlsoRises = new BookRequestDto();
        theSunAlsoRises.setBookName("The Sun Also Rises");
        theSunAlsoRises.setPublishedAmount(376_000L);
        theSunAlsoRises.setSoldAmount(350_000L);
        theSunAlsoRises.setAuthorId(ernestHemingwayId);
        bookService.createBook(theSunAlsoRises);

        BookRequestDto farewellToArms = new BookRequestDto();
        farewellToArms.setBookName("A Farewell to Arms");
        farewellToArms.setPublishedAmount(261_000L);
        farewellToArms.setSoldAmount(198_000L);
        farewellToArms.setAuthorId(ernestHemingwayId);
        bookService.createBook(farewellToArms);
    }
}
