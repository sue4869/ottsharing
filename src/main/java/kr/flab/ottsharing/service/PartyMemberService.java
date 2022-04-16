package kr.flab.ottsharing.service;

import org.springframework.stereotype.Service;

import kr.flab.ottsharing.entity.Party;
import kr.flab.ottsharing.entity.PartyMember;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartyMemberService {

    public Boolean checkLeader(PartyMember partyMember) {
        return partyMember.isLeader();
    }

    public Party getParty(PartyMember partyMember) {
        return partyMember.getParty();
    }
}