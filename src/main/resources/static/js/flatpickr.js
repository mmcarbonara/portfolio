let maxDate = new　Date();
maxDate = maxDate.setMonth(maxDate.getMonth() + 3);  

flatpickr('#ReservedDate', {
	mode: "range",
    locale: 'ja',
    minDate: 'today',
    maxdate: maxDate
});
