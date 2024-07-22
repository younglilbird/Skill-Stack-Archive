from django.contrib import admin
from .models import Member

# Register your models here. Johndoe, 12345678

class MemberAdmin(admin.ModelAdmin):
  list_display = ("firstname", "lastname", "joined_date",)

admin.site.register(Member, MemberAdmin)