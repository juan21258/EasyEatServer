class CreateBases < ActiveRecord::Migration
  def change
    create_table :bases do |t|
      t.string :nombre
      t.timestamps null: false
    end
  end
end
