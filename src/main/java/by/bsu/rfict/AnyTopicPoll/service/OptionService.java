package by.bsu.rfict.AnyTopicPoll.service;

import by.bsu.rfict.AnyTopicPoll.entity.Option;
import by.bsu.rfict.AnyTopicPoll.repository.OptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;

    @Transactional
    public Option createOption(Option option) {
        Option createdOption = optionRepository.save(option);
        return createdOption;
    }
}
