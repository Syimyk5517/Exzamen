package org.example.repasitory;

import org.example.entity.SocialMedia;

import java.util.List;

public interface SocialMediaRepasitory {
    String save(SocialMedia socialMedia);
    SocialMedia getSocialMediaPersonName(String name);
    String deleteById(Long id);
    List<SocialMedia> getAllSocialMediaSortByNameByDesc();
}
