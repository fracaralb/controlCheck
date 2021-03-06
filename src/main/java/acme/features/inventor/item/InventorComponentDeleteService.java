package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorComponentDeleteService implements AbstractDeleteService<Inventor, Item>{
	// Internal state ------------------------------------------------
	
		@Autowired
		protected InventorItemRepository itemRepo;
				
				
		@Override
		public boolean authorise(final Request<Item> request) {
			assert request != null;
			final boolean result;
			int itemId;
			final Item item;

			itemId=request.getModel().getInteger("id");
			item=this.itemRepo.findItemById(itemId);
			final int inventorId = request.getPrincipal().getActiveRoleId();

			result= !item.isPublished() && item.getInventor().getId()==inventorId;

			return result;
		}
		
		@Override
		public void bind(final Request<Item> request, final Item entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
			
			
			request.bind(entity, errors, "name","code",  "technology", "description", "retailPrice", "link");
		}
		
		@Override
		public void unbind(final Request<Item> request, final Item entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			
			request.unbind(entity, model, "name","code", "technology", "description", "retailPrice", "link");
			
		}
		
		@Override
		public Item findOne(final Request<Item> request) {
			assert request != null;

			Item result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.itemRepo.findItemById(id);
			
			

			return result;
		}
		
		@Override
		public void validate(final Request<Item> request, final Item entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
			
			
		}
		
		@Override
		public void delete(final Request<Item> request, final Item entity) {
			assert request != null;
			assert entity != null;
			
			this.itemRepo.deleteQuantityByItemId(entity.getId());
			this.itemRepo.delete(entity);
			
			
		}
		

		

	}
