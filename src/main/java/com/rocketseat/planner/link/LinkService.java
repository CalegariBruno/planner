package com.rocketseat.planner.link;

import com.rocketseat.planner.activity.Activity;
import com.rocketseat.planner.activity.ActivityData;
import com.rocketseat.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;

    public LinkResponse register(LinkRequestPayload payload, Trip trip){
        Link link = new Link(payload.title(), payload.url(), trip);
        this.repository.save(link);
        return new LinkResponse(link.getId());
    }

    public List<LinkData> getAllLinkFromId(UUID id){
        return this.repository.findByTripId(id)
                .stream()
                .map(link -> new LinkData(
                        link.getId(),
                        link.getTitle(),
                        link.getUrl()
                )).toList();
    }

}
