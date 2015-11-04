class CreateProductos < ActiveRecord::Migration
  def change
    create_table :productos do |t|
      t.integer :precio
      t.string :descripcion
      t.string :tiempoespera
      t.integer :cantidad

      t.timestamps null: false
    end
  end
end
