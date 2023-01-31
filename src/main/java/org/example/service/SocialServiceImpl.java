package org.example.service;

import org.example.entity.SocialMedia;
import org.example.repasitory.SocialMediaRepasitory;
import org.example.repasitory.SocialMediaRepasitoryImpl;

import java.util.List;

public class SocialServiceImpl implements SocialService{
  SocialMediaRepasitory socialMediaRepasitory = new SocialMediaRepasitoryImpl();
    @Override
    public String save(SocialMedia socialMedia) {
        socialMediaRepasitory.save(socialMedia);

        return "!!!";
    }

    @Override
    public SocialMedia getSocialMediaPersonName(String name) {
        return socialMediaRepasitory.getSocialMediaPersonName(name);
    }

    @Override
    public String deleteById(Long id) {
        socialMediaRepasitory.deleteById(id);
        return "!!";
    }

    @Override
    public List<SocialMedia> getAllSocialMediaSortByNameByDesc() {
        return socialMediaRepasitory.getAllSocialMediaSortByNameByDesc();
    }
}
