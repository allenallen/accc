package com.accc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.accc.domain.model.JobOrder;
import com.accc.domain.model.Parts;
import com.accc.repository.PartsRepository;
import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class PartsServiceImplTest {

	@InjectMocks
	private PartsServiceImpl partsService;

	@Mock
	private PartsRepository partsRepository;

	private Parts parts;

	private ArgumentCaptor<Parts> captor;

	private JobOrder jobOrder;
	
	private LocalDate date = LocalDate.of(2005, 1, 1);

	@Before
	public void init() {
		jobOrder = new JobOrder(date, null, null, Lists.newArrayList(), null, null, BigDecimal.TEN,
				LocalDate.of(2005, 1, 1), date);
		parts = new Parts(1, "Test", "Test", date, BigDecimal.ONE, jobOrder);
		captor = ArgumentCaptor.forClass(Parts.class);
	}

	@Test
	public void findByJobOrder_success() {
		when(partsService.findAllByJobOrder(jobOrder)).thenReturn(Lists.newArrayList(parts));
		
		List<Parts> found = partsService.findAllByJobOrder(jobOrder);
	
		assertEquals(1, found.size());
	}
	
	@Test
	public void findByDate_success() {
		when(partsService.findAllByDate(date)).thenReturn(Lists.newArrayList(parts));
		
		List<Parts> found = partsService.findAllByDate(date);
		
		assertEquals(1, found.size());
	}
	
	@Test
	public void create_success() {
		partsService.create(parts);
		
		verify(partsRepository).save(captor.capture());
		
		Parts created = captor.getValue();
		
		assertEquals("Test",created.getDescription());
		assertEquals(Integer.valueOf(1), created.getQuantity());
	}
}
