$(document).ready(function() {
    // Create Property
    $('#createPropertyForm').on('submit', function(event) {
        event.preventDefault();
        const propertyData = {
            pgName: $('#pgName').val(),
            pgType: $('#pgType').val(),
            pgAddress: $('#pgAddress').val(),
            pgPhoneNumber: $('#pgPhoneNumber').val(),
            pgEmail: $('#pgEmail').val(),
            userId: 1 // Example user ID, replace with dynamic user ID if available
        };

        $.ajax({
            url: '/properties/addProperty',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(propertyData),
            success: function(response) {
                alert('Property created successfully!');
            },
            error: function(error) {
                alert('Error creating property: ' + error.responseText);
            }
        });
    });

    // Fetch All Properties
    $('#fetchPropertiesButton').on('click', function() {
        $.ajax({
            url: '/properties',
            method: 'GET',
            success: function(response) {
                const propertiesList = $('#propertiesList');
                propertiesList.empty();
                response.forEach(property => {
                    propertiesList.append('<li>' + property.pgName + ' (' + property.pgType + ')</li>');
                });
            },
            error: function(error) {
                alert('Error fetching properties: ' + error.responseText);
            }
        });
    });

    // Update Property
    $('#updatePropertyForm').on('submit', function(event) {
        event.preventDefault();
        const propertyId = $('#updatePropertyId').val();
        const propertyData = {
            pgName: $('#updatePgName').val(),
            pgType: $('#updatePgType').val(),
            pgAddress: $('#updatePgAddress').val(),
            pgPhoneNumber: $('#updatePgPhoneNumber').val(),
            pgEmail: $('#updatePgEmail').val()
        };

        $.ajax({
            url: '/properties/' + propertyId,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(propertyData),
            success: function(response) {
                alert('Property updated successfully!');
            },
            error: function(error) {
                alert('Error updating property: ' + error.responseText);
            }
        });
    });

    // Delete Property
    $('#deletePropertyForm').on('submit', function(event) {
        event.preventDefault();
        const propertyId = $('#deletePropertyId').val();

        $.ajax({
            url: '/properties/' + propertyId,
            method: 'DELETE',
            success: function(response) {
                alert('Property deleted successfully!');
            },
            error: function(error) {
                alert('Error deleting property: ' + error.responseText);
            }
        });
    });
});
