package io.finsther.shoppingCart.controller;

import io.finsther.shoppingCart.model.Brick;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrickController {

    @RequestMapping(value = "api/bricks/{id}")
    public Brick getBrick(@PathVariable String id) {
        Brick brick = new Brick();
        brick.setId(1);
        brick.setName("Cinemex");
        brick.setImgURL("Cinemex.com/img-background.jpg");
        brick.setQuantity(100);
        brick.setPrice(400d);

        return brick;
    }

    @RequestMapping(value = "api/bricks")
    public Brick getBricks() {
        Brick brick = new Brick();
        brick.setName("Cinemex");
        return brick;
    }
}
