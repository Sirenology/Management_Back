package com.example.management_backend.services.artist;

import com.example.management_backend.pojo.VO.ArtistVO;

import java.util.List;

public interface ArtistService {
    List<ArtistVO> getAllArtistInfo();
    void deleteArtist(Integer artistId);
    void createArtist(String artist);
}
