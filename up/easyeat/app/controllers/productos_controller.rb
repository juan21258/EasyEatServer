class ProductosController < ApplicationController
  respond_to :json
  PER_PAGE_RECORDS = 9
  #GET /productos.json
  #def index
  #	@productos = Producto.all
  #	#respond_with(@tournaments)
  #end
  def index
    productos_paginated = Producto.order('precio').page(params[:page]).per(PER_PAGE_RECORDS)
    json_response = {
      models: productos_paginated,
      current_page: params[:page].to_i,
      perPage: PER_PAGE_RECORDS,
      total_pages: productos_paginated.num_pages
  }
  respond_with json_response, callback: params[:callback]
  
  end
end
