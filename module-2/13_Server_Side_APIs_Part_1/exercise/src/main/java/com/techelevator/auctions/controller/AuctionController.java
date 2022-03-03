package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(
            @RequestParam(required = false, defaultValue = "") String title_like,
            @RequestParam(required = false, defaultValue = "0.0") double currentBid_lte) {
        boolean haveTitleCriteria = !title_like.equals("");
        boolean havePriceCriteria = currentBid_lte > (double) 0;

//        if (!haveTitleCriteria && !havePriceCriteria) {
//            return dao.list();
//        } else if (haveTitleCriteria && !havePriceCriteria) {
//            return dao.searchByTitle(title_like);
//        } else if (!haveTitleCriteria) {
//            return dao.searchByPrice(currentBid_lte);
//        } else return dao.searchByTitleAndPrice(title_like,currentBid_lte);
        if (havePriceCriteria && haveTitleCriteria) {
            return dao.searchByTitleAndPrice(title_like,currentBid_lte);
        } else if (havePriceCriteria) {
            return dao.searchByPrice(currentBid_lte);
        } else if (haveTitleCriteria) {
            return dao.searchByTitle(title_like);
        } else {
            return dao.list();
        }

    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    @PostMapping()
    public Auction create(@RequestBody Auction auction) {
        return dao.create(auction);
    }
}
