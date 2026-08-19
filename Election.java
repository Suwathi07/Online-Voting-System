package voting;

import java.util.ArrayList;
import java.util.List;

public class Election {
    String type;
    List<Candidate> candidates = new ArrayList<>();

    Election(String type) {
        this.type = type;
    }

    void addCandidate(String name) {
        candidates.add(new Candidate(name));
    }

    void castVote(int index) {
        candidates.get(index).votes++;
    }
}