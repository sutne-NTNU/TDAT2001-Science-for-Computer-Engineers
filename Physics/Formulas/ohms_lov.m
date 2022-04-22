function res = ohms_lov(U, R, I)
if U==0
	res = R * I;
elseif R == 0
	res = U/I;
else
	res = U/R;
end
end

