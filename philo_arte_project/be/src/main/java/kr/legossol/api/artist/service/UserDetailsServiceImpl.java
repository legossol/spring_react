package kr.legossol.api.artist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.artist.repository.ArtistRepository;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ArtistRepository repository;

    @Transactional // 동기로 처리해야하는 부분에 사용. 특히 금융권 ATM 등
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Optional의 객체로 감싼다.
        Optional<Artist> artist = Optional.ofNullable(repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username : " + username)));

        return UserDetailsImpl.build(artist.get()); // .get은 Optional 객체에서 끄집어 낸다.
    }


}