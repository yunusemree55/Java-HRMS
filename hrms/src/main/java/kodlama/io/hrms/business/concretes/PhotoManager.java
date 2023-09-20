package kodlama.io.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.PhotoService;
import kodlama.io.hrms.business.requests.photoRequests.AddPhotoRequest;
import kodlama.io.hrms.business.requests.photoRequests.UpdatePhotoRequest;
import kodlama.io.hrms.business.responses.photoResponses.GetAllPhotoResponse;
import kodlama.io.hrms.core.adapter.CloudinaryService;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.PhotoRepository;
import kodlama.io.hrms.entities.concretes.Photo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PhotoManager implements PhotoService {

	private PhotoRepository photoRepository;
	private CloudinaryService cloudinaryService;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllPhotoResponse> getAll() {

		List<GetAllPhotoResponse> photoResponseList = photoRepository.findAll().stream()
				.map(photo -> modelMapperService.forResponse().map(photo, GetAllPhotoResponse.class))
				.collect(Collectors.toList());

		return photoResponseList;

	}

	@Override
	public void add(AddPhotoRequest addPhotoRequest) {

		System.out.println(addPhotoRequest.getUrl());
		Photo photo = modelMapperService.forRequest().map(addPhotoRequest, Photo.class);
		photo.setId(0);

		try {

			cloudinaryService.uploadFile(addPhotoRequest.getUrl());

			photo.setUrl(cloudinaryService.uploadFile(addPhotoRequest.getUrl()));

			photoRepository.save(photo);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void update(UpdatePhotoRequest updatePhotoRequest) {

		Photo target = photoRepository.getPhotoByUserId(updatePhotoRequest.getUserId());

		Photo photo = modelMapperService.forRequest().map(target, Photo.class);
		photo.setUrl(target.getUrl());

		

		try {

			cloudinaryService.uploadFile(updatePhotoRequest.getUrl());

			photo.setUrl(cloudinaryService.uploadFile(updatePhotoRequest.getUrl()));

			photoRepository.save(photo);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public GetAllPhotoResponse getPhotoByUserId(int id) {
		Photo target = photoRepository.getPhotoByUserId(id);
		
		if(target != null) {
			
			GetAllPhotoResponse photoResponse = modelMapperService.forResponse().map(target, GetAllPhotoResponse.class);
			return photoResponse;
			
		}

		return null;
		
	}

}
