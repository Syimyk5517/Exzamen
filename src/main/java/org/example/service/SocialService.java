package org.example.service;

import org.example.entity.SocialMedia;

import java.util.List;

public interface SocialService {
    String save(SocialMedia socialMedia);
    SocialMedia getSocialMediaPersonName(String name);
    String deleteById(Long id);
    List<SocialMedia> getAllSocialMediaSortByNameByDesc();
}
