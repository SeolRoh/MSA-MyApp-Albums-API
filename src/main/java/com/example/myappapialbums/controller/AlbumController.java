package com.example.myappapialbums.controller;

import com.example.myappapialbums.data.AlbumEntity;
import com.example.myappapialbums.model.AlbumResponseModel;
import com.example.myappapialbums.service.AlbumsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users/{id}/albums")
public class AlbumController {

    @Autowired
    Environment env;

    @Autowired
    AlbumsService albumsService;

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })

    public List<AlbumResponseModel> userAlbums(@PathVariable String id) {
        List<AlbumResponseModel> returnValue = new ArrayList<>();

        List<AlbumEntity> albumEntities = albumsService.getAlbums(id);

        if(albumEntities == null || albumEntities.isEmpty())
        {
            return returnValue;
        }

        Type listType = new TypeToken<List<AlbumResponseModel>>(){}.getType();

        returnValue = new ModelMapper().map(albumEntities, listType);
        log.info("Returning " + returnValue.size() + " albums");
        return returnValue;
    }

}
